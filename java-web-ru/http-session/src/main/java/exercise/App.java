package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            List<Map<String, String>> midList = new ArrayList<>();
            if (!ctx.queryParamMap().isEmpty()) {
                ctx.queryParamMap();
                int step = ctx.queryParamAsClass("per", Integer.class).get();
                int page = ctx.queryParamAsClass("page", Integer.class).get();
                for (int i = 0; i < step; i++) {
                    midList.add(USERS.get((page * step) - step + i));
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    midList.add(USERS.get(j));
                }
            }
            ctx.json(midList);
        });

        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

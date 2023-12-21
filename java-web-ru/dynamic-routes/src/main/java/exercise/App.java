package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN

        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", String.class).get();
            int index = 0;
            boolean found = false;
            for (Map<String, String> map : COMPANIES) {
                for (Map.Entry<String, String> m : map.entrySet()) {
                    if (m.getKey().equals("id") && m.getValue().equals(id)){
                        ctx.json(COMPANIES.get(index));
                        found = true;
                    }
                }
                index++;
            }
            if (!found) {
                throw new NotFoundResponse();
            }
            //ctx.result("We're in concrete company" + id);
        });

        app.exception(NotFoundResponse.class, (e, ctx) -> {
            ctx.status(404);
        }).error(404, ctx -> {
            ctx.result("Company not found");
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).get();
            User user = USERS.stream()
                    .filter(n -> n.getId() == id)
                    .findFirst()
                            .orElse(null);
            if (user == null) {
                throw new NotFoundResponse("User not found");
            }
            var header = "That guy!";
            var page = new UserPage(user, header);
            ctx.render("users/show.jte", Collections.singletonMap("page", page));
        });

        app.get("/users", ctx -> {
            var header = "All users";
            var page = new UsersPage(USERS, header);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        /*app.exception(NotFoundResponse.class, (e, ctx) -> {
            ctx.status(404);
        }).error(404, ctx -> {
            ctx.result("User not found");
        });*/
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

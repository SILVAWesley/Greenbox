package controllers;

import models.User;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    @Inject
    private FormFactory formFactory;
    private List<User> listUsers = new ArrayList<>();

    public Result index() {
        return ok(index.render("Green Box"));
    }

    public Result cadastrarUser() {
        User user = formFactory.form(User.class).bindFromRequest().get();
        listUsers.add(user);
        return redirect(routes.Application.login());
        //User user = new User("dsf","asdas","sadas");
        //return ok(cadastro.render(user));
    }

    public Result login() {
        return ok(home.render());
    }

}

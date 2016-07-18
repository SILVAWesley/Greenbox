package controllers;

import models.User;
import play.mvc.*;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    private List<User> listUsers = new ArrayList<>();

    public static Result index() {
        return ok(views.html.index.render("Green Box"));
    }

    public static Result cadastro() {
        return ok(cadastro.render("Cadastro"));
    }

    public static  Result login() {
        return ok(home.render());
    }





}

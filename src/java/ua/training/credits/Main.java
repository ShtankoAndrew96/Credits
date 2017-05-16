package ua.training.credits;

import ua.training.credits.controller.Controller;
import ua.training.credits.model.Model;
import ua.training.credits.view.View;

import java.util.Locale;

/**
 * Created by andrew on 06.05.2017.
 */
public class Main {
    public static void main(String[] args){
        Locale.setDefault(new Locale("uk","UA"));//new Locale("ru","RU")
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }
}

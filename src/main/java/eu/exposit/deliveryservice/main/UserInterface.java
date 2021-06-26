package eu.exposit.deliveryservice.main;

import eu.exposit.deliveryservice.menu.Menu;
import eu.exposit.deliveryservice.menu.MenuContext;

public class UserInterface {

    private UserInterface() {

    }

    public static void run() {
        while (true) {
            Menu menu = MenuContext.getCurrentMenu();
            System.out.println();
            for (int i = 0; i < menu.getItems().size(); i++) {
                System.out.println((i + 1) + "." + menu.getItems().get(i).getText());
            }
            System.out.print("Ваш выбор: ");
            menu.executeSelectedFunction();
        }
    }

}

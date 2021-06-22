package eu.exposit.deliveryservice.actions.client;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ClientController;
import eu.exposit.deliveryservice.model.Client;
import eu.exposit.deliveryservice.utils.ConsoleUtil;

import java.util.Scanner;

public class RegisterClientAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        Scanner scanner = ConsoleUtil.getScanner();
        scanner.nextLine();

        Client newClient = new Client();

        System.out.print("\nИмя: ");
        newClient.setName(scanner.nextLine());
        System.out.print("Фамилия: ");
        newClient.setSurname(scanner.nextLine());
        System.out.print("Номер: ");
        newClient.setNumber(scanner.nextLine());

        ClientController.getInstance().register(newClient);

    }

}

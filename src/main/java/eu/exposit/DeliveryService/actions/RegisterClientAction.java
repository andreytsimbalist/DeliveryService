package eu.exposit.DeliveryService.actions;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ClientController;
import eu.exposit.DeliveryService.model.Client;
import eu.exposit.DeliveryService.utils.ConsoleUtil;

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

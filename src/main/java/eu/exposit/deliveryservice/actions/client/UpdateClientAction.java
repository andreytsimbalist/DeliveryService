package eu.exposit.deliveryservice.actions.client;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ClientController;
import eu.exposit.deliveryservice.exceptions.ListIsEmptyException;
import eu.exposit.deliveryservice.model.Client;
import eu.exposit.deliveryservice.utils.ConsoleUtil;

import java.util.List;
import java.util.Scanner;

public class UpdateClientAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        ClientController clientController = ClientController.getInstance();
        Scanner scanner = ConsoleUtil.getScanner();


        List<Client> clients = clientController.getAll();

        if (clients.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (int i = 0; i < clients.size(); i++) {
            System.out.println("\n" + (i + 1) + clients.get(i).toString());
        }

        System.out.print("\nНомер редактируемой записи: ");
        Client client = clients.get(scanner.nextInt() - 1);
        scanner.nextLine();
        System.out.print("Новое имя: ");
        client.setName(scanner.nextLine());
        System.out.print("Новая фамилия: ");
        client.setSurname(scanner.nextLine());
        System.out.print("Новый номер: ");
        client.setNumber(scanner.nextLine());

        clientController.update(client);

    }

}

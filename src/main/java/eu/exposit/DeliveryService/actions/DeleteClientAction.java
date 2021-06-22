package eu.exposit.DeliveryService.actions;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ClientController;
import eu.exposit.DeliveryService.exceptions.ListIsEmptyException;
import eu.exposit.DeliveryService.model.Client;
import eu.exposit.DeliveryService.utils.ConsoleUtil;

import java.util.List;

public class DeleteClientAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        ClientController clientController = ClientController.getInstance();

        List<Client> clients = clientController.getAll();

        if (clients.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (int i = 0; i < clients.size(); i++) {
            System.out.println("\n" + (i + 1) + clients.get(i).toString());
        }

        System.out.print("\nНомер удаляемой записи: ");
        clientController.delete(clients.get(ConsoleUtil.getScanner().nextInt() - 1));

    }

}

package eu.exposit.DeliveryService.actions.client;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ClientController;
import eu.exposit.DeliveryService.exceptions.ListIsEmptyException;
import eu.exposit.DeliveryService.model.Client;

import java.util.List;

public class DisplayClientsAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        List<Client> clients = ClientController.getInstance().getAll();

        if (clients.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (Client client : clients) {
            System.out.println(client);
        }

    }

}

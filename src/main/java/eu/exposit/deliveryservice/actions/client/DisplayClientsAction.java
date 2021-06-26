package eu.exposit.deliveryservice.actions.client;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ClientController;
import eu.exposit.deliveryservice.exceptions.ListIsEmptyException;
import eu.exposit.deliveryservice.model.Client;

import java.util.List;

public class DisplayClientsAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        List<Client> clients = ClientController.getInstance().getAll();

        if (clients.isEmpty()) {
            throw new ListIsEmptyException();
        }

        clients.forEach(System.out::println);

    }

}

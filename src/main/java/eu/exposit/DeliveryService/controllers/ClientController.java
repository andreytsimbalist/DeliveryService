package eu.exposit.DeliveryService.controllers;

import eu.exposit.DeliveryService.api.services.ClientService;
import eu.exposit.DeliveryService.exceptions.NoRecordException;
import eu.exposit.DeliveryService.exceptions.RecordAlreadyExistsException;
import eu.exposit.DeliveryService.model.Client;
import eu.exposit.DeliveryService.services.ClientServiceImpl;

import java.util.List;

public class ClientController {

    private final ClientService clientService;

    private ClientController() {
        clientService = ClientServiceImpl.getInstance();
    }

    private static ClientController instance;

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Client register(Client client) throws RecordAlreadyExistsException {
        return clientService.create(client);
    }

    public List<Client> getAll() {
        return clientService.getAll();
    }

    public Client get(Client client) throws NoRecordException {
        return clientService.get(client);
    }

    public Client update(Client client) {
        return clientService.update(client);
    }

    public void delete(Client client) throws NoRecordException {
        clientService.delete(client);
    }

}

package eu.exposit.deliveryservice.controllers;

import eu.exposit.deliveryservice.api.services.ClientService;
import eu.exposit.deliveryservice.exceptions.NoRecordException;
import eu.exposit.deliveryservice.exceptions.RecordAlreadyExistsException;
import eu.exposit.deliveryservice.model.Client;
import eu.exposit.deliveryservice.services.ClientServiceImpl;

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

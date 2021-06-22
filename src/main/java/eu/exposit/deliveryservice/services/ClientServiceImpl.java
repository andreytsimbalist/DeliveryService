package eu.exposit.deliveryservice.services;

import eu.exposit.deliveryservice.api.services.ClientService;
import eu.exposit.deliveryservice.exceptions.RecordAlreadyExistsException;
import eu.exposit.deliveryservice.model.Client;
import eu.exposit.deliveryservice.repositories.ClientRepositoryImpl;

public class ClientServiceImpl extends CrudServiceImpl<Client> implements ClientService {

    private ClientServiceImpl() {
        crudRepository = ClientRepositoryImpl.getInstance();
    }

    private static ClientService instance;

    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientServiceImpl();
        }
        return instance;
    }

    @Override
    public Client create(Client client) throws RecordAlreadyExistsException {
        for (Client temp : crudRepository.getAll()) {
            if (temp.getName().equals(client.getName()) &&
                    temp.getSurname().equals(client.getSurname()) &&
                    temp.getNumber().equals(client.getNumber())) {
                throw new RecordAlreadyExistsException();
            }
        }
        return super.create(client);
    }

}

package eu.exposit.DeliveryService.services;

import eu.exposit.DeliveryService.api.services.ClientService;
import eu.exposit.DeliveryService.exceptions.RecordAlreadyExistsException;
import eu.exposit.DeliveryService.model.Client;
import eu.exposit.DeliveryService.repositories.ClientRepositoryImpl;

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

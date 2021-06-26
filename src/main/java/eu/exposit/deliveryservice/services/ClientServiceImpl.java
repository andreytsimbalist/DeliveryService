package eu.exposit.deliveryservice.services;

import eu.exposit.deliveryservice.api.repositories.ClientRepository;
import eu.exposit.deliveryservice.api.services.ClientService;
import eu.exposit.deliveryservice.exceptions.RecordAlreadyExistsException;
import eu.exposit.deliveryservice.model.Client;
import eu.exposit.deliveryservice.repositories.ClientRepositoryImpl;

public class ClientServiceImpl extends CrudServiceImpl<Client> implements ClientService {

    private final ClientRepository clientRepository;

    private ClientServiceImpl() {
        crudRepository = ClientRepositoryImpl.getInstance();
        clientRepository = (ClientRepository) crudRepository;
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
        for (Client temp : clientRepository.getAll()) {
            if (temp.getName().equals(client.getName()) &&
                    temp.getSurname().equals(client.getSurname()) &&
                    temp.getNumber().equals(client.getNumber())) {
                throw new RecordAlreadyExistsException();
            }
        }
        return super.create(client);
    }

}

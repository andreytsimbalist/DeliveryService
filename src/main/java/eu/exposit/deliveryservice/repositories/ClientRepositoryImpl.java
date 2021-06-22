package eu.exposit.deliveryservice.repositories;

import eu.exposit.deliveryservice.datastorage.ClientDatabase;
import eu.exposit.deliveryservice.api.repositories.ClientRepository;
import eu.exposit.deliveryservice.model.Client;

public class ClientRepositoryImpl extends CrudRepositoryImpl<Client> implements ClientRepository {

    private ClientRepositoryImpl() {
        abstractDatabase = ClientDatabase.getInstance();
    }

    private static ClientRepository instance;

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepositoryImpl();
        }
        return instance;
    }

}

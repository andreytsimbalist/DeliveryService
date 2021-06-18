package eu.exposit.DeliveryService.repositories;

import eu.exposit.DeliveryService.DataStorage.AbstractDatabase;
import eu.exposit.DeliveryService.DataStorage.ClientDatabase;
import eu.exposit.DeliveryService.api.repositories.ClientRepository;
import eu.exposit.DeliveryService.model.Client;

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

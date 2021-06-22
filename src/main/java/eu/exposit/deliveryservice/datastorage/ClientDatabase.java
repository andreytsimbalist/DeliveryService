package eu.exposit.deliveryservice.datastorage;

import eu.exposit.deliveryservice.model.Client;

public class ClientDatabase extends AbstractDatabase<Client> {

    private ClientDatabase() {

    }

    private static ClientDatabase instance;

    public static ClientDatabase getInstance() {
        if (instance == null) {
            instance = new ClientDatabase();
        }
        return instance;
    }

}

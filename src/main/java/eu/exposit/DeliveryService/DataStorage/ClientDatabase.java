package eu.exposit.DeliveryService.DataStorage;

import eu.exposit.DeliveryService.model.Client;

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

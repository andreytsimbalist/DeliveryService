package eu.exposit.DeliveryService.DataStorage;

import eu.exposit.DeliveryService.model.Client;
import eu.exposit.DeliveryService.model.Shop;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

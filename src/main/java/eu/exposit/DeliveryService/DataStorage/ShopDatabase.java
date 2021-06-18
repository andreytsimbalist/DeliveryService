package eu.exposit.DeliveryService.DataStorage;

import eu.exposit.DeliveryService.model.Shop;

public class ShopDatabase extends AbstractDatabase<Shop> {

    private ShopDatabase() {

    }

    private static ShopDatabase instance;

    public static ShopDatabase getInstance() {
        if (instance == null) {
            instance = new ShopDatabase();
        }
        return instance;
    }

}

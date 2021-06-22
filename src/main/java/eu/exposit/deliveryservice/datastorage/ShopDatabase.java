package eu.exposit.deliveryservice.datastorage;

import eu.exposit.deliveryservice.model.Shop;

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

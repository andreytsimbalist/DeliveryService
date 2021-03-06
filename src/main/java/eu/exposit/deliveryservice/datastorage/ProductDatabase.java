package eu.exposit.deliveryservice.datastorage;

import eu.exposit.deliveryservice.model.Product;

public class ProductDatabase extends AbstractDatabase<Product> {

    private ProductDatabase() {

    }

    private static ProductDatabase instance;

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

}

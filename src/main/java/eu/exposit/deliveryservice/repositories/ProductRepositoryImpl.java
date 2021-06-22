package eu.exposit.deliveryservice.repositories;

import eu.exposit.deliveryservice.datastorage.ProductDatabase;
import eu.exposit.deliveryservice.api.repositories.ProductRepository;
import eu.exposit.deliveryservice.model.Product;

public class ProductRepositoryImpl extends CrudRepositoryImpl<Product> implements ProductRepository {

    private ProductRepositoryImpl() {
        abstractDatabase = ProductDatabase.getInstance();
    }

    private static ProductRepository instance;

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepositoryImpl();
        }
        return instance;
    }

}

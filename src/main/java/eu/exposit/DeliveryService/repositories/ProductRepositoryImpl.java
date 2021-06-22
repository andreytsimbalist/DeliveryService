package eu.exposit.DeliveryService.repositories;

import eu.exposit.DeliveryService.DataStorage.ProductDatabase;
import eu.exposit.DeliveryService.api.repositories.ProductRepository;
import eu.exposit.DeliveryService.model.Product;

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

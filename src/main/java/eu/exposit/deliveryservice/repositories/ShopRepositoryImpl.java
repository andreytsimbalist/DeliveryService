package eu.exposit.deliveryservice.repositories;

import eu.exposit.deliveryservice.controllers.ShopController;
import eu.exposit.deliveryservice.datastorage.ShopDatabase;
import eu.exposit.deliveryservice.api.repositories.ShopRepository;
import eu.exposit.deliveryservice.model.Product;
import eu.exposit.deliveryservice.model.Shop;

public class ShopRepositoryImpl extends CrudRepositoryImpl<Shop> implements ShopRepository {

    private ShopRepositoryImpl() {
        abstractDatabase = ShopDatabase.getInstance();
    }

    private static ShopRepository instance;

    public static ShopRepository getInstance() {
        if (instance == null) {
            instance = new ShopRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void deleteProducts(Product product) {
        for (Shop shop : ShopController.getInstance().getAll()) {
            shop.getStocks().removeIf(stock -> stock.getProduct().equals(product));
        }
    }

}

package eu.exposit.DeliveryService.repositories;

import eu.exposit.DeliveryService.DataStorage.ShopDatabase;
import eu.exposit.DeliveryService.api.repositories.ShopRepository;
import eu.exposit.DeliveryService.model.Shop;

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

}

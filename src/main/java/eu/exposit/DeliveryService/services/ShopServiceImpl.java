package eu.exposit.DeliveryService.services;

import eu.exposit.DeliveryService.api.services.ShopService;
import eu.exposit.DeliveryService.model.Shop;
import eu.exposit.DeliveryService.repositories.ShopRepositoryImpl;

public class ShopServiceImpl extends CrudServiceImpl<Shop> implements ShopService {

    private ShopServiceImpl() {
        crudRepository = ShopRepositoryImpl.getInstance();
    }

    private static ShopService instance;

    public static ShopService getInstance() {
        if (instance == null) {
            instance = new ShopServiceImpl();
        }
        return instance;
    }

}

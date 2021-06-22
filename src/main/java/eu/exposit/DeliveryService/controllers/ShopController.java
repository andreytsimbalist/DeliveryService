package eu.exposit.DeliveryService.controllers;

import eu.exposit.DeliveryService.api.services.ShopService;
import eu.exposit.DeliveryService.exceptions.NoRecordException;
import eu.exposit.DeliveryService.exceptions.RecordAlreadyExistsException;
import eu.exposit.DeliveryService.model.Shop;
import eu.exposit.DeliveryService.model.Stock;
import eu.exposit.DeliveryService.model.enums.SortKey;
import eu.exposit.DeliveryService.services.ShopServiceImpl;

import java.util.List;

public class ShopController {

    private final ShopService shopService;

    private ShopController() {
        shopService = ShopServiceImpl.getInstance();
    }

    private static ShopController instance;

    public static ShopController getInstance() {
        if (instance == null) {
            instance = new ShopController();
        }
        return instance;
    }

    public List<Shop> getAll() {
        return shopService.getAll();
    }

    public Shop register(Shop shop) throws RecordAlreadyExistsException {
        return shopService.create(shop);
    }

    public void update(Shop shop) {
        shopService.update(shop);
    }

    public void delete(Shop shop) throws NoRecordException {
        shopService.delete(shop);
    }

    public List<Stock> getStocksSortedByKey(SortKey sortKey) {
        return shopService.sortByKey(sortKey);
    }

}

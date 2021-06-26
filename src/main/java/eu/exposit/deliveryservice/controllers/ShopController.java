package eu.exposit.deliveryservice.controllers;

import eu.exposit.deliveryservice.api.services.ShopService;
import eu.exposit.deliveryservice.exceptions.NoRecordException;
import eu.exposit.deliveryservice.exceptions.RecordAlreadyExistsException;
import eu.exposit.deliveryservice.model.Product;
import eu.exposit.deliveryservice.model.Shop;
import eu.exposit.deliveryservice.model.Stock;
import eu.exposit.deliveryservice.model.enums.SortKey;
import eu.exposit.deliveryservice.services.ShopServiceImpl;

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

    public void deleteProductFromShops(Product product) {
        shopService.deleteProducts(product);
    }

}

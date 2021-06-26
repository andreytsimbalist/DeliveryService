package eu.exposit.deliveryservice.services;

import eu.exposit.deliveryservice.api.repositories.ShopRepository;
import eu.exposit.deliveryservice.api.services.ShopService;
import eu.exposit.deliveryservice.exceptions.RecordAlreadyExistsException;
import eu.exposit.deliveryservice.model.Product;
import eu.exposit.deliveryservice.model.Shop;
import eu.exposit.deliveryservice.model.Stock;
import eu.exposit.deliveryservice.model.enums.SortKey;
import eu.exposit.deliveryservice.repositories.ShopRepositoryImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopServiceImpl extends CrudServiceImpl<Shop> implements ShopService {

    private final ShopRepository shopRepository;

    private ShopServiceImpl() {
        crudRepository = ShopRepositoryImpl.getInstance();
        shopRepository = (ShopRepository) crudRepository;
    }

    private static ShopService instance;

    public static ShopService getInstance() {
        if (instance == null) {
            instance = new ShopServiceImpl();
        }
        return instance;
    }

    @Override
    public Shop create(Shop shop) throws RecordAlreadyExistsException {
        for (Shop temp : shopRepository.getAll()) {
            if (temp.getName().equalsIgnoreCase(shop.getName()) &&
                    temp.getAddress().equalsIgnoreCase(shop.getAddress())) {
                throw new RecordAlreadyExistsException();
            }
        }
        return super.create(shop);
    }

    public List<Stock> sortByKey(SortKey sortKey) {
        List<Stock> stocks = new ArrayList<>();
        for (Shop shop : shopRepository.getAll()) {
            stocks.addAll(shop.getStocks());
        }
        switch (sortKey) {
            case PRICE:
                stocks = stocks.stream().sorted(Comparator.comparing(Stock::getPrice)).collect(Collectors.toList());
                break;
            case NAME:
                stocks.sort(Comparator.comparing(stock -> stock.getProduct().getName()));
                break;
        }
        return stocks;
    }

    @Override
    public void deleteProducts(Product product) {
        shopRepository.deleteProducts(product);
    }

}

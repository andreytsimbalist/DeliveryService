package eu.exposit.deliveryservice.api.services;

import eu.exposit.deliveryservice.model.Shop;
import eu.exposit.deliveryservice.model.Stock;
import eu.exposit.deliveryservice.model.enums.SortKey;

import java.util.List;

public interface ShopService extends CrudService<Shop> {

    List<Stock> sortByKey(SortKey sortKey);

}

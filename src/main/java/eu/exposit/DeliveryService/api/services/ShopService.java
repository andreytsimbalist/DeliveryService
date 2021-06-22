package eu.exposit.DeliveryService.api.services;

import eu.exposit.DeliveryService.model.Shop;
import eu.exposit.DeliveryService.model.Stock;
import eu.exposit.DeliveryService.model.enums.SortKey;

import java.util.List;

public interface ShopService extends CrudService<Shop> {

    List<Stock> sortByKey(SortKey sortKey);

}

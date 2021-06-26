package eu.exposit.deliveryservice.api.repositories;

import eu.exposit.deliveryservice.model.Product;
import eu.exposit.deliveryservice.model.Shop;

public interface ShopRepository extends CrudRepository<Shop> {

    void deleteProducts(Product product);

}

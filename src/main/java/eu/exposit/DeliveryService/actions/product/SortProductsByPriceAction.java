package eu.exposit.DeliveryService.actions.product;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ProductController;
import eu.exposit.DeliveryService.controllers.ShopController;
import eu.exposit.DeliveryService.model.Shop;
import eu.exposit.DeliveryService.model.Stock;
import eu.exposit.DeliveryService.model.enums.SortKey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortProductsByPriceAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        ShopController.getInstance().getStocksSortedByKey(SortKey.PRICE).forEach(System.out::println);

    }

}

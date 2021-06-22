package eu.exposit.deliveryservice.actions.product;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ShopController;
import eu.exposit.deliveryservice.model.enums.SortKey;

public class SortProductsByPriceAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        ShopController.getInstance().getStocksSortedByKey(SortKey.PRICE).forEach(System.out::println);

    }

}

package eu.exposit.deliveryservice.actions.shop;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ShopController;
import eu.exposit.deliveryservice.exceptions.ListIsEmptyException;
import eu.exposit.deliveryservice.model.Shop;

import java.util.List;

public class DisplayShopsAction implements Action {

    @Override
    public void execute(int index) throws Exception {
        List<Shop> shops = ShopController.getInstance().getAll();

        if (shops.isEmpty()) {
            throw new ListIsEmptyException();
        }

        shops.forEach(System.out::println);
    }

}

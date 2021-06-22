package eu.exposit.DeliveryService.actions.shop;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ShopController;
import eu.exposit.DeliveryService.exceptions.ListIsEmptyException;
import eu.exposit.DeliveryService.model.Shop;

import java.util.List;

public class DisplayShopsAction implements Action {

    @Override
    public void execute(int index) throws Exception {
        List<Shop> shops = ShopController.getInstance().getAll();

        if (shops.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (Shop shop : shops) {
            System.out.println(shop);
        }
    }

}

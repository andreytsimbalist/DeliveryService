package eu.exposit.deliveryservice.actions.shop;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ShopController;
import eu.exposit.deliveryservice.exceptions.ListIsEmptyException;
import eu.exposit.deliveryservice.model.Shop;
import eu.exposit.deliveryservice.utils.ConsoleUtil;

import java.util.List;

public class DeleteShopAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        ShopController shopController = ShopController.getInstance();

        List<Shop> shops = shopController.getAll();

        if (shops.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (int i = 0; i < shops.size(); i++) {
            System.out.println("\n" + (i + 1) + shops.get(i).toString());
        }

        System.out.print("\nНомер удаляемой записи: ");
        shopController.delete(shops.get(ConsoleUtil.getScanner().nextInt() - 1));

    }

}

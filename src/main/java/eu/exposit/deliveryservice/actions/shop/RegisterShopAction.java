package eu.exposit.deliveryservice.actions.shop;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ShopController;
import eu.exposit.deliveryservice.model.Shop;
import eu.exposit.deliveryservice.utils.ConsoleUtil;

import java.util.Scanner;

public class RegisterShopAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        Scanner scanner = ConsoleUtil.getScanner();
        Shop newShop = new Shop();
        scanner.nextLine();

        System.out.print("\nНазвание магазина: ");
        newShop.setName(scanner.nextLine());
        System.out.print("Адрес магазина: ");
        newShop.setAddress(scanner.nextLine());
        ShopController.getInstance().register(newShop);

    }

}

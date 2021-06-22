package eu.exposit.DeliveryService.actions.product;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ShopController;
import eu.exposit.DeliveryService.exceptions.ListIsEmptyException;
import eu.exposit.DeliveryService.model.Shop;
import eu.exposit.DeliveryService.model.Stock;
import eu.exposit.DeliveryService.utils.ConsoleUtil;

import java.util.List;
import java.util.Scanner;

public class UpdateStockAction implements Action {

    @Override
    public void execute(int index) throws Exception {
        ShopController shopController = ShopController.getInstance();
        Scanner scanner = ConsoleUtil.getScanner();

        List<Shop> shops = shopController.getAll();

        if (shops.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (int i = 0; i < shops.size(); i++) {
            System.out.println("\n" + (i + 1) + shops.get(i).toString());
        }

        System.out.print("\nНомер магазина для радобты с товарами: ");
        Shop shop = shops.get(scanner.nextInt() - 1);

        List<Stock> stocks = shop.getStocks();

        for (int i = 0; i < stocks.size(); i++) {
            System.out.println("\n" + (i + 1) + stocks.get(i).toString());
        }

        if (stocks.isEmpty()){
            throw new ListIsEmptyException();
        }

        System.out.print("\nНомер товара для изменения: ");
        Stock stock = stocks.get(scanner.nextInt() - 1);
        System.out.print("Новая цена: ");
        stock.setPrice(scanner.nextFloat());
        System.out.print("Новое количество: ");
        stock.setCount(scanner.nextInt());

        shopController.update(shop);

    }

}

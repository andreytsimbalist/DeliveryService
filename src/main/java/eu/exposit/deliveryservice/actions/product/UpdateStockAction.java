package eu.exposit.deliveryservice.actions.product;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ShopController;
import eu.exposit.deliveryservice.exceptions.ListIsEmptyException;
import eu.exposit.deliveryservice.model.Shop;
import eu.exposit.deliveryservice.model.Stock;
import eu.exposit.deliveryservice.utils.ConsoleUtil;

import java.util.List;
import java.util.Scanner;

public class UpdateStockAction implements Action {

    @Override
    public void execute(int index) throws Exception {
        ShopController shopController = ShopController.getInstance();
        Scanner scanner = ConsoleUtil.getScanner();

        List<Shop> shops = shopController.getAll();

        displayList(shops);

        System.out.print("\nНомер магазина для радобты с товарами: ");
        Shop shop = shops.get(scanner.nextInt() - 1);

        List<Stock> stocks = shop.getStocks();

        displayList(stocks);

        System.out.print("\nНомер товара для изменения: ");
        Stock stock = stocks.get(scanner.nextInt() - 1);
        System.out.print("Новая цена: ");
        stock.setPrice(scanner.nextFloat());
        System.out.print("Новое количество: ");
        stock.setCount(scanner.nextInt());

        shopController.update(shop);

    }

    private void displayList(List<?> entity) throws ListIsEmptyException {
        if (entity.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (int i = 0; i < entity.size(); i++) {
            System.out.println("\n" + (i + 1) + entity.get(i).toString());
        }
    }

}

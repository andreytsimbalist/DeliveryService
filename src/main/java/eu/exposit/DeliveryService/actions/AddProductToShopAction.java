package eu.exposit.DeliveryService.actions;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ProductController;
import eu.exposit.DeliveryService.controllers.ShopController;
import eu.exposit.DeliveryService.exceptions.RecordAlreadyExistsException;
import eu.exposit.DeliveryService.model.Product;
import eu.exposit.DeliveryService.model.Shop;
import eu.exposit.DeliveryService.model.Stock;
import eu.exposit.DeliveryService.utils.ConsoleUtil;

import java.util.List;
import java.util.Scanner;

public class AddProductToShopAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        ShopController shopController = ShopController.getInstance();
        Scanner scanner = ConsoleUtil.getScanner();

        List<Shop> shops = shopController.getAll();

        for (int i = 0; i < shops.size(); i++) {
            System.out.println("\n" + (i + 1) + shops.get(i).toString());
        }

        System.out.print("\nНомер магазина в который нужно добавить продукт: ");
        Shop shop = shops.get(scanner.nextInt() - 1);

        List<Product> products = ProductController.getInstance().getAll();

        for (int i = 0; i < products.size(); i++) {
            System.out.println("\n" + (i + 1) + products.get(i).toString());
        }

        Stock stock = new Stock();

        System.out.print("\nНомер товара который нужно добавить: ");
        stock.setProduct(products.get(scanner.nextInt() - 1));
        if (shop.getStocks().stream().anyMatch(entity -> entity.getProduct().equals(stock.getProduct()))){
            throw new RecordAlreadyExistsException();
        }
        System.out.print("Цена: ");
        stock.setPrice(scanner.nextFloat());
        System.out.print("Количество: ");
        stock.setCount(scanner.nextInt());
        shop.getStocks().add(stock);
        shopController.update(shop);

    }

}

package eu.exposit.deliveryservice.actions.shop;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ProductController;
import eu.exposit.deliveryservice.controllers.ShopController;
import eu.exposit.deliveryservice.exceptions.ListIsEmptyException;
import eu.exposit.deliveryservice.exceptions.RecordAlreadyExistsException;
import eu.exposit.deliveryservice.model.BaseEntity;
import eu.exposit.deliveryservice.model.Product;
import eu.exposit.deliveryservice.model.Shop;
import eu.exposit.deliveryservice.model.Stock;
import eu.exposit.deliveryservice.utils.ConsoleUtil;

import java.util.List;
import java.util.Scanner;

public class AddProductToShopAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        ShopController shopController = ShopController.getInstance();
        Scanner scanner = ConsoleUtil.getScanner();

        List<Shop> shops = shopController.getAll();

        displayList(shops);

        System.out.print("\nНомер магазина в который нужно добавить продукт: ");
        Shop shop = shops.get(scanner.nextInt() - 1);

        List<Product> products = ProductController.getInstance().getAll();

        displayList(products);

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

    private <T extends BaseEntity> void displayList(List<T> entity) throws ListIsEmptyException {
        if (entity.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (int i = 0; i < entity.size(); i++) {
            System.out.println("\n" + (i + 1) + entity.get(i).toString());
        }
    }

}

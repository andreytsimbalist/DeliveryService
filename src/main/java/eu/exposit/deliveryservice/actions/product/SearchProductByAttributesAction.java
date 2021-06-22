package eu.exposit.deliveryservice.actions.product;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ShopController;
import eu.exposit.deliveryservice.model.Shop;
import eu.exposit.deliveryservice.model.Stock;
import eu.exposit.deliveryservice.model.enums.Category;
import eu.exposit.deliveryservice.model.enums.SortKey;
import eu.exposit.deliveryservice.utils.ConsoleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchProductByAttributesAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        ShopController shopController = ShopController.getInstance();
        Scanner scanner = ConsoleUtil.getScanner();

        Category[] values = Category.values();
        List<Stock> stocks = new ArrayList<>();
        List<Category> categories = new ArrayList<>();

        for (Shop shop : shopController.getAll()) {
            stocks.addAll(shop.getStocks());
        }

        boolean next = true;
        int choice;
        while (next) {
            System.out.println("\nДобавить атрибут для поиска товара:");
            System.out.print("1. Категория\n2. Цена\n3. Количество\n4. Очистить атрибуты\n5. Поиск\nВаш выбор: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("\nВыберите категорию:");
                        for (int i = 0; i < values.length; i++) {
                            System.out.println((i + 1) + ". " + values[i].getDescription());
                        }
                        System.out.print((values.length + 1) + ". Завершить\nВаш выбор: ");
                        choice = scanner.nextInt();
                        if (choice == values.length + 1) {
                            break;
                        }
                        try {
                            categories.add(values[choice - 1]);
                        } catch (IndexOutOfBoundsException exception) {
                            System.out.println("\nТакого пункта нет!\n");
                        }
                    }
                    List<Category> finalCategories = categories.stream().distinct().collect(Collectors.toList());
                    stocks.removeIf(stock -> !stock.getProduct().getCategories().containsAll(finalCategories));
                    break;
                case 2:
                    System.out.print("\nСумма: ");
                    float price = scanner.nextFloat();
                    stocks.removeIf(stock -> stock.getPrice() > price);
                    break;
                case 3:
                    System.out.print("\nКоличество: ");
                    int count = scanner.nextInt();
                    stocks.removeIf(stock -> stock.getCount() < count);
                    break;
                case 4:
                    stocks.clear();
                    for (Shop shop : shopController.getAll()) {
                        stocks.addAll(shop.getStocks());
                    }
                    break;
                case 5:
                    next = false;
                    break;
                default:
                    System.out.println("\nТакого пункта нет!\n");
            }
        }

        shopController.getStocksSortedByKey(SortKey.NAME).forEach(System.out::println);

    }

}

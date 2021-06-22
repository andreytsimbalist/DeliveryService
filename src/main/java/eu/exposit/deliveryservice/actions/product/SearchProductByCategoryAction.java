package eu.exposit.deliveryservice.actions.product;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ProductController;
import eu.exposit.deliveryservice.model.Product;
import eu.exposit.deliveryservice.model.enums.Category;
import eu.exposit.deliveryservice.utils.ConsoleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchProductByCategoryAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        Scanner scanner = ConsoleUtil.getScanner();
        Category[] values = Category.values();
        List<Category> categories = new ArrayList<>();

        int choice;
        while (true) {
            System.out.println("\nВыберите категорию для товара:");
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

        categories = categories.stream().distinct().collect(Collectors.toList());

        boolean isContain = false;
        for (Product product : ProductController.getInstance().getAll()) {
            if (product.getCategories().containsAll(categories)) {
                System.out.println(product);
                isContain = true;
            }
        }

        if (!isContain){
            System.out.println("\nПродуктов в заданных категориях нет.");
        }

    }

}

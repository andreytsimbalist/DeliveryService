package eu.exposit.DeliveryService.actions.product;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ProductController;
import eu.exposit.DeliveryService.model.Product;
import eu.exposit.DeliveryService.model.enums.Category;
import eu.exposit.DeliveryService.utils.ConsoleUtil;

import java.util.Scanner;
import java.util.stream.Collectors;

public class CreateProductAction implements Action {

    @Override
    public void execute(int index) throws Exception {

        Scanner scanner = ConsoleUtil.getScanner();
        scanner.nextLine();

        Product product = new Product();
        System.out.print("\nНазвание нового продукта: ");
        product.setName(scanner.nextLine());

        Category[] values = Category.values();

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
                product.getCategories().add(values[choice - 1]);
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("\nТакого пункта нет!\n");
            }
        }

        product.setCategories(product.getCategories().stream().distinct().collect(Collectors.toList()));

        ProductController.getInstance().create(product);

    }

}

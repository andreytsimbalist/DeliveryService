package eu.exposit.DeliveryService.actions.product;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ProductController;
import eu.exposit.DeliveryService.exceptions.ListIsEmptyException;
import eu.exposit.DeliveryService.model.Product;
import eu.exposit.DeliveryService.model.enums.Category;
import eu.exposit.DeliveryService.utils.ConsoleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UpdateProductAction implements Action {

    @Override
    public void execute(int index) throws Exception {
        ProductController productController = ProductController.getInstance();
        Scanner scanner = ConsoleUtil.getScanner();


        List<Product> products = productController.getAll();

        if (products.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (int i = 0; i < products.size(); i++) {
            System.out.println("\n" + (i + 1) + products.get(i).toString());
        }

        System.out.print("\nНомер редактируемой записи: ");
        Product product = products.get(scanner.nextInt() - 1);
        product.setCategories(new ArrayList<>());
        scanner.nextLine();
        System.out.print("Новое название: ");
        product.setName(scanner.nextLine());

        Category[] values = Category.values();

        int choice;
        while (true) {
            System.out.println("\nВыберите новые категории:");
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

        productController.update(product);

    }

}

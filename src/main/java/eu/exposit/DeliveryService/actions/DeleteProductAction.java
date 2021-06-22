package eu.exposit.DeliveryService.actions;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ProductController;
import eu.exposit.DeliveryService.controllers.ShopController;
import eu.exposit.DeliveryService.exceptions.ListIsEmptyException;
import eu.exposit.DeliveryService.model.Product;
import eu.exposit.DeliveryService.model.Shop;
import eu.exposit.DeliveryService.utils.ConsoleUtil;

import java.util.List;

public class DeleteProductAction implements Action {

    @Override
    public void execute(int index) throws Exception {
        ProductController productController = ProductController.getInstance();

        List<Product> products = productController.getAll();

        if (products.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (int i = 0; i < products.size(); i++) {
            System.out.println("\n" + (i + 1) + products.get(i).toString());
        }

        System.out.print("\nНомер удаляемой записи: ");
        Product productToDelete = products.get(ConsoleUtil.getScanner().nextInt() - 1);

        for (Shop shop : ShopController.getInstance().getAll()) {
            shop.getStocks().removeIf(stock -> stock.getProduct().equals(productToDelete));
        }

        productController.delete(productToDelete);

    }

}

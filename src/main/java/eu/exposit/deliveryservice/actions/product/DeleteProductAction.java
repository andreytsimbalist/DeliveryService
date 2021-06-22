package eu.exposit.deliveryservice.actions.product;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ProductController;
import eu.exposit.deliveryservice.controllers.ShopController;
import eu.exposit.deliveryservice.exceptions.ListIsEmptyException;
import eu.exposit.deliveryservice.model.Product;
import eu.exposit.deliveryservice.model.Shop;
import eu.exposit.deliveryservice.utils.ConsoleUtil;

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

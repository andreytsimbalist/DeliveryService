package eu.exposit.DeliveryService.actions;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.ProductController;
import eu.exposit.DeliveryService.exceptions.ListIsEmptyException;
import eu.exposit.DeliveryService.model.Product;

import java.util.List;

public class DisplayProductsAction implements Action {
    @Override
    public void execute(int index) throws Exception {
        List<Product> products = ProductController.getInstance().getAll();

        if (products.isEmpty()) {
            throw new ListIsEmptyException();
        }

        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}

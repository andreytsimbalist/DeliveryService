package eu.exposit.deliveryservice.actions.product;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.ProductController;
import eu.exposit.deliveryservice.exceptions.ListIsEmptyException;
import eu.exposit.deliveryservice.model.Product;

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

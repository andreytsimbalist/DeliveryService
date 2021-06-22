package eu.exposit.DeliveryService.controllers;

import eu.exposit.DeliveryService.api.services.ProductService;
import eu.exposit.DeliveryService.exceptions.NoRecordException;
import eu.exposit.DeliveryService.exceptions.RecordAlreadyExistsException;
import eu.exposit.DeliveryService.model.Product;
import eu.exposit.DeliveryService.services.ProductServiceImpl;

import java.util.List;

public class ProductController {

    private final ProductService productService;

    private ProductController() {
        productService = ProductServiceImpl.getInstance();
    }

    private static ProductController instance;

    public static ProductController getInstance() {
        if (instance == null) {
            instance = new ProductController();
        }
        return instance;
    }

    public Product create(Product product) throws RecordAlreadyExistsException {
        return productService.create(product);
    }

    public List<Product> getAll() {
        return productService.getAll();
    }

    public void update(Product product) {
        productService.update(product);
    }

    public void delete(Product product) throws NoRecordException {
        productService.delete(product);
    }

}

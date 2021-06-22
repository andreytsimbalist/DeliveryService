package eu.exposit.DeliveryService.services;

import eu.exposit.DeliveryService.api.services.ProductService;
import eu.exposit.DeliveryService.exceptions.RecordAlreadyExistsException;
import eu.exposit.DeliveryService.model.Product;
import eu.exposit.DeliveryService.repositories.ProductRepositoryImpl;

public class ProductServiceImpl extends CrudServiceImpl<Product> implements ProductService {

    private ProductServiceImpl() {
        crudRepository = ProductRepositoryImpl.getInstance();
    }

    private static ProductService instance;

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public Product create(Product product) throws RecordAlreadyExistsException {
        for (Product temp : crudRepository.getAll()) {
            if (temp.getName().equalsIgnoreCase(product.getName())) {
                throw new RecordAlreadyExistsException();
            }
        }
        return super.create(product);
    }

}

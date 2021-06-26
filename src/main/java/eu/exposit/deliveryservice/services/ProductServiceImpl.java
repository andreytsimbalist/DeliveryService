package eu.exposit.deliveryservice.services;

import eu.exposit.deliveryservice.api.repositories.ProductRepository;
import eu.exposit.deliveryservice.api.services.ProductService;
import eu.exposit.deliveryservice.exceptions.RecordAlreadyExistsException;
import eu.exposit.deliveryservice.model.Product;
import eu.exposit.deliveryservice.repositories.ProductRepositoryImpl;

public class ProductServiceImpl extends CrudServiceImpl<Product> implements ProductService {

    private final ProductRepository productRepository;

    private ProductServiceImpl() {
        crudRepository = ProductRepositoryImpl.getInstance();
        productRepository = (ProductRepository) crudRepository;
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
        for (Product temp : productRepository.getAll()) {
            if (temp.getName().equalsIgnoreCase(product.getName())) {
                throw new RecordAlreadyExistsException();
            }
        }
        return super.create(product);
    }

}

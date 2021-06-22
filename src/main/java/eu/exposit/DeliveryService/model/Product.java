package eu.exposit.DeliveryService.model;

import eu.exposit.DeliveryService.model.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    private List<Category> categories;

    public Product() {
        categories = new ArrayList<>();
    }

    public Product(Product product){
        name = product.getName();
        categories = product.getCategories();
        id = product.getId();
    }

    private String categoriesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Category category : categories) {
            stringBuilder.append("\n— ").append(category.getDescription());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "\nНазвание товара: " + name +
                "\nКатегории: " + categoriesToString();
    }

}

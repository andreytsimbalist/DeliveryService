package eu.exposit.deliveryservice.model;

import eu.exposit.deliveryservice.model.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumSet;

@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    private EnumSet<Category> categories;

    public Product() {
        categories = EnumSet.noneOf(Category.class);
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

package eu.exposit.DeliveryService.model;

import eu.exposit.DeliveryService.model.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product extends BaseEntity {

    private List<Category> categories;
    private Double price;
    private Integer capacity;

}

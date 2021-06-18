package eu.exposit.DeliveryService.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Shop extends BaseEntity {

    private String name;
    private List<Product> products;

}

package eu.exposit.DeliveryService.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client extends BaseEntity {

    private String name;
    private String surname;
    private String number;

}

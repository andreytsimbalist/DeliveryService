package eu.exposit.DeliveryService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends BaseEntity {

    private String name;
    private String surname;
    private String number;

    public Client(Client client) {
        name = client.getName();
        surname = client.getSurname();
        number = client.getNumber();
        id = client.getId();
    }

    @Override
    public String toString() {
        return "\nИмя: " + name +
                "\nФамилия: " + surname +
                "\nНомер: " + number;
    }

}

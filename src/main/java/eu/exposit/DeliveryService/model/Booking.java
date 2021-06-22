package eu.exposit.DeliveryService.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Booking extends BaseEntity {

    private Client client;
    private List<Shop> shops;
    private float total;

    public Booking() {
        shops = new ArrayList<>();
    }

    private String shopsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Shop shop : shops) {
            stringBuilder.append(shop);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "\nИнофрмация заказа:" +
                "\nКлиент" + client.toString() +
                "\nМагазины" + shopsToString() +
                "\nИтого: " + total;
    }
}

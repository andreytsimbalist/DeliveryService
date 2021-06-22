package eu.exposit.deliveryservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Shop extends BaseEntity {

    private String name;
    private String address;
    private List<Stock> stocks;

    public Shop() {
        stocks = new ArrayList<>();
    }

    public Shop(Shop shop) {
        name = shop.getName();
        address = shop.getAddress();
        stocks = new ArrayList<>();
        id = shop.getId();
    }

    private String stocksToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Stock stock : stocks) {
            stringBuilder.append(stock.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "\nНазвание магазина: " + name +
                "\nАдрес магазина: " + address +
                "\nПродукты" + (stocks.isEmpty() ? "\nПока пусто." : stocksToString());
    }
}

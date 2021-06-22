package eu.exposit.deliveryservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Stock {

    private Product product;
    private float price;
    private int count;

    public Stock(Stock stock ){
        product = stock.getProduct();
        price = stock.getPrice();
        count = stock.getCount();
    }

    @Override
    public String toString() {
        return product.toString() +
                "\nЦена: " + price +
                "\nКоличество: " + count;
    }

}

package eu.exposit.DeliveryService.exceptions;

public class NotEnoughProductException extends Exception {

    @Override
    public String getMessage() {
        return "\nНедостаточно товара в магазине.";
    }

}

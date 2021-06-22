package eu.exposit.DeliveryService.exceptions;

public class ListIsEmptyException extends Exception {

    @Override
    public String getMessage() {
        return "\nСписок пуст.";
    }

}

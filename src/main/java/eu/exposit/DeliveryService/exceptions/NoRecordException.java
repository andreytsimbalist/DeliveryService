package eu.exposit.DeliveryService.exceptions;

public class NoRecordException extends Exception {

    @Override
    public String getMessage() {
        return "\nТакой записи в базе данных нет.";
    }

}

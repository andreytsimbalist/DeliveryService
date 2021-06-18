package eu.exposit.DeliveryService.exceptions;

public class NoRecordException extends Exception {

    @Override
    public String getMessage() {
        return "No such record in database.";
    }

}

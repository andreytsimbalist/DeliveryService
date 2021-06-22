package eu.exposit.DeliveryService.exceptions;

public class RecordAlreadyExistsException extends Exception {

    @Override
    public String getMessage() {
        return "\nЗапись уже существует.";
    }

}

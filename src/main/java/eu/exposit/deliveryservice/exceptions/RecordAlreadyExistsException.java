package eu.exposit.deliveryservice.exceptions;

public class RecordAlreadyExistsException extends Exception {

    @Override
    public String getMessage() {
        return "\nЗапись уже существует.";
    }

}

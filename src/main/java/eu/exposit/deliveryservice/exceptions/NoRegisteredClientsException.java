package eu.exposit.deliveryservice.exceptions;

public class NoRegisteredClientsException extends Exception {

    @Override
    public String getMessage() {
        return "\nСписок клиентов пуст. Пройдите регистрацию.";
    }

}

package eu.exposit.deliveryservice.actions.booking;

import eu.exposit.deliveryservice.api.actions.Action;
import eu.exposit.deliveryservice.controllers.BookingController;
import eu.exposit.deliveryservice.exceptions.ListIsEmptyException;

public class DisplayBookingsAction implements Action {

    @Override
    public void execute(int index) throws Exception {
        BookingController bookingController = BookingController.getInstance();

        if (bookingController.getAll().isEmpty()){
            throw new ListIsEmptyException();
        }

        bookingController.getAll().forEach(System.out::println);

    }

}

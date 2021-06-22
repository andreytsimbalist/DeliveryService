package eu.exposit.DeliveryService.actions;

import eu.exposit.DeliveryService.api.actions.Action;
import eu.exposit.DeliveryService.controllers.BookingController;
import eu.exposit.DeliveryService.exceptions.ListIsEmptyException;

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

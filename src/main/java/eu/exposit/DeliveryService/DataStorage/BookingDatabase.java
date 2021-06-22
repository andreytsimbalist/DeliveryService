package eu.exposit.DeliveryService.DataStorage;

import eu.exposit.DeliveryService.model.Booking;

public class BookingDatabase extends AbstractDatabase<Booking> {

    private BookingDatabase() {

    }

    private static BookingDatabase instance;

    public static BookingDatabase getInstance() {
        if (instance == null) {
            instance = new BookingDatabase();
        }
        return instance;
    }

}

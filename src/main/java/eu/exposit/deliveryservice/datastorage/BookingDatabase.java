package eu.exposit.deliveryservice.datastorage;

import eu.exposit.deliveryservice.model.Booking;

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

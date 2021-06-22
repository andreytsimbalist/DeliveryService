package eu.exposit.deliveryservice.repositories;

import eu.exposit.deliveryservice.datastorage.BookingDatabase;
import eu.exposit.deliveryservice.api.repositories.BookingRepository;
import eu.exposit.deliveryservice.model.Booking;

public class BookingRepositoryImpl extends CrudRepositoryImpl<Booking> implements BookingRepository {

    private BookingRepositoryImpl() {
        abstractDatabase = BookingDatabase.getInstance();
    }

    private static BookingRepository instance;

    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepositoryImpl();
        }
        return instance;
    }

}

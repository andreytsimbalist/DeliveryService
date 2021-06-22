package eu.exposit.DeliveryService.repositories;

import eu.exposit.DeliveryService.DataStorage.BookingDatabase;
import eu.exposit.DeliveryService.api.repositories.BookingRepository;
import eu.exposit.DeliveryService.model.Booking;

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

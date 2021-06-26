package eu.exposit.deliveryservice.services;

import eu.exposit.deliveryservice.api.repositories.BookingRepository;
import eu.exposit.deliveryservice.api.services.BookingService;
import eu.exposit.deliveryservice.model.Booking;
import eu.exposit.deliveryservice.repositories.BookingRepositoryImpl;

public class BookingServiceImpl extends CrudServiceImpl<Booking> implements BookingService {

    private final BookingRepository bookingRepository;

    private BookingServiceImpl() {
        crudRepository = BookingRepositoryImpl.getInstance();
        bookingRepository = (BookingRepository) crudRepository;
    }

    private static BookingService instance;

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingServiceImpl();
        }
        return instance;
    }

}

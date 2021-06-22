package eu.exposit.DeliveryService.services;

import eu.exposit.DeliveryService.api.services.BookingService;
import eu.exposit.DeliveryService.model.Booking;
import eu.exposit.DeliveryService.repositories.BookingRepositoryImpl;

public class BookingServiceImpl extends CrudServiceImpl<Booking> implements BookingService {

    private BookingServiceImpl() {
        crudRepository = BookingRepositoryImpl.getInstance();
    }

    private static BookingService instance;

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingServiceImpl();
        }
        return instance;
    }

}

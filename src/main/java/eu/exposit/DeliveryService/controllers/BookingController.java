package eu.exposit.DeliveryService.controllers;

import eu.exposit.DeliveryService.api.services.BookingService;
import eu.exposit.DeliveryService.exceptions.RecordAlreadyExistsException;
import eu.exposit.DeliveryService.model.Booking;
import eu.exposit.DeliveryService.services.BookingServiceImpl;

import java.util.List;

public class BookingController {

    private final BookingService bookingService;

    private BookingController() {
        bookingService = BookingServiceImpl.getInstance();
    }

    private static BookingController instance;

    public static BookingController getInstance() {
        if (instance == null) {
            instance = new BookingController();
        }
        return instance;
    }

    public Booking create(Booking booking) throws RecordAlreadyExistsException {
        return bookingService.create(booking);
    }

    public List<Booking> getAll() {
        return bookingService.getAll();
    }

}

package eu.exposit.deliveryservice.controllers;

import eu.exposit.deliveryservice.api.services.BookingService;
import eu.exposit.deliveryservice.exceptions.RecordAlreadyExistsException;
import eu.exposit.deliveryservice.model.Booking;
import eu.exposit.deliveryservice.services.BookingServiceImpl;

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

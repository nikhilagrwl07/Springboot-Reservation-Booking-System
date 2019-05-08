package com.nikhil.RestaurantReservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReservationAlreadyBookedException extends RuntimeException {
    public ReservationAlreadyBookedException(String message) {
        super(message);
    }
}

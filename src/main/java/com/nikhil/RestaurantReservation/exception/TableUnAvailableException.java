package com.nikhil.RestaurantReservation.exception;

public class TableUnAvailableException extends RuntimeException {
    public TableUnAvailableException(String message) {
        super(message);
    }
}

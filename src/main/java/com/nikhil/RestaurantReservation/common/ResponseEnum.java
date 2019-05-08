package com.nikhil.RestaurantReservation.common;

public enum ResponseEnum {
    TABLE_UNAVAILABLE("All tables are booked presently. Please try after sometime"),
    RESERVATION_ALREADY_BOOKED("Reservation for same request is already booked"),
    INVALID_RESERVATION_ID("Reservation id is invalid. Please pass correct reservation id");
    String message;

    ResponseEnum(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

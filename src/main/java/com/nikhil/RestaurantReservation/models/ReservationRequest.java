package com.nikhil.RestaurantReservation.models;

import lombok.Data;

@Data
public class ReservationRequest {
    private String userContactNumber;
    private String restaurantContactNumber;
    private int startTime;
    private int duration;
    private int numberOfPerson;

}

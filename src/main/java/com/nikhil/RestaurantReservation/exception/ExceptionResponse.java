package com.nikhil.RestaurantReservation.exception;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ExceptionResponse {
    private UUID uuid; // required for tracing a web call
    private Date timestamp; // required for grepping by time
    private String uri; // required knowing URI resource has thrown this exception
    private String message; // message for knowing cause of exception

    public ExceptionResponse(Date timestamp, String uri, String message) {
        this.uuid = UUID.randomUUID();
        this.timestamp = timestamp;
        this.uri = uri;
        this.message = message;
    }
}

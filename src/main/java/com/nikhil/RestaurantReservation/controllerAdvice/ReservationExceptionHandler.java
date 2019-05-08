package com.nikhil.RestaurantReservation.controllerAdvice;

import com.nikhil.RestaurantReservation.exception.ExceptionResponse;
import com.nikhil.RestaurantReservation.exception.InvalidReservationException;
import com.nikhil.RestaurantReservation.exception.ReservationAlreadyBookedException;
import com.nikhil.RestaurantReservation.exception.TableUnAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.UUID;

@ControllerAdvice
@RestController
public class ReservationExceptionHandler {

//    @ExceptionHandler(value = {TableUnAvailableException.class, ReservationAlreadyBookedException.class})
//    public ResponseEntity<ExceptionResponse> tableUnavailableExceptionHandler
//            (WebRequest httpRequestHandler, Exception ex){
//
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
//                ((ServletWebRequest) httpRequestHandler).getRequest().getRequestURI(), ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
//    }

    @ExceptionHandler(value = {TableUnAvailableException.class, ReservationAlreadyBookedException.class,
                InvalidReservationException.class})
    public ResponseEntity<ExceptionResponse> invalidExceptionHandler
            (WebRequest httpRequestHandler, Exception ex){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                ((ServletWebRequest) httpRequestHandler).getRequest().getRequestURI(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}

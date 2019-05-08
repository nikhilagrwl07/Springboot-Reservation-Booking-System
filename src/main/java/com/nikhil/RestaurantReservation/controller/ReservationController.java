package com.nikhil.RestaurantReservation.controller;

import com.nikhil.RestaurantReservation.models.ReservationRequest;
import com.nikhil.RestaurantReservation.service.ReservationService;
import com.nikhil.RestaurantReservation.table.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/reservation")
public class ReservationController {

    final private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Integer> bookReservation(@RequestBody ReservationRequest reservationRequest) {
        Long reservation = reservationService.bookReservation(reservationRequest);


        URI savedUserUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reservation)
                .toUri();

        return ResponseEntity.created(savedUserUri).build();
    }

    @GetMapping(path = "/{reservationId}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        return ResponseEntity.ok(reservation);
    }

    @PutMapping(path = "/{reservationId}")
    public ResponseEntity<Integer> updateReservation(@RequestBody ReservationRequest reservationRequest,
                                                     @PathVariable Long reservationId) {
        reservationService.updateReservation(reservationRequest, reservationId);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping(path = "/{reservationId}")
    public ResponseEntity<Integer> updateReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return ResponseEntity.status(200).build();
    }

}

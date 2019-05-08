package com.nikhil.RestaurantReservation.service;

import com.nikhil.RestaurantReservation.exception.InvalidReservationException;
import com.nikhil.RestaurantReservation.exception.ReservationAlreadyBookedException;
import com.nikhil.RestaurantReservation.exception.TableUnAvailableException;
import com.nikhil.RestaurantReservation.models.ReservationRequest;
import com.nikhil.RestaurantReservation.respository.ReservationRepository;
import com.nikhil.RestaurantReservation.respository.RestaurantRepository;
import com.nikhil.RestaurantReservation.respository.UserRepository;
import com.nikhil.RestaurantReservation.table.Reservation;
import com.nikhil.RestaurantReservation.table.Restaurant;
import com.nikhil.RestaurantReservation.table.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.nikhil.RestaurantReservation.common.ResponseEnum.*;

@Service
public class ReservationService {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(UserRepository userRepository, RestaurantRepository restaurantRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.reservationRepository = reservationRepository;
    }

    public Long bookReservation(ReservationRequest reservationRequest) {

        // Condition 1 - table is available
        Restaurant restaurantAvailable = isTableAvailable(reservationRequest);

        User user = userRepository.findByContactNumber(reservationRequest.getUserContactNumber());

        // Condition 2 - don't allow more than one booking for one user with same restaurant and time slot
        isReservationAlreadyBooked(user,restaurantAvailable,reservationRequest);

        Reservation reservation = new Reservation(user, restaurantAvailable, reservationRequest.getStartTime(),
                                reservationRequest.getStartTime() + reservationRequest.getDuration(), reservationRequest.getNumberOfPerson());

        return reservationRepository.save(reservation).getId();
    }


    private Restaurant isTableAvailable(ReservationRequest reservationRequest) {
        Restaurant restaurant = restaurantRepository.findByContactNumber(reservationRequest.getRestaurantContactNumber());
        boolean tableAvaliable = restaurant.isTableAvailable(1);
        if (!tableAvaliable)
            throw new TableUnAvailableException(TABLE_UNAVAILABLE.getMessage());

        return restaurant;
    }

    private void isReservationAlreadyBooked(User user, Restaurant restaurantAvailable, ReservationRequest reservationRequest){
        Reservation reservationByCustomDetails = reservationRepository.findReservationByCustomDetails(user, restaurantAvailable, reservationRequest.getStartTime(),
                reservationRequest.getStartTime() + reservationRequest.getDuration(), true);

        if (reservationByCustomDetails!=null){
            throw new ReservationAlreadyBookedException(RESERVATION_ALREADY_BOOKED.getMessage());
        }
    }

    public Reservation getReservationById(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);

        if(!reservation.isPresent()){
            throw new InvalidReservationException(INVALID_RESERVATION_ID.getMessage());
        }
        return reservation.get();
    }
}

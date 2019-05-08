package com.nikhil.RestaurantReservation.respository;

import com.nikhil.RestaurantReservation.table.Reservation;
import com.nikhil.RestaurantReservation.table.Restaurant;
import com.nikhil.RestaurantReservation.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT r FROM Reservation r WHERE r.user = :user_id and " +
            "r.restaurant=:restaurant_id and r.startTime=:startTime and r.endTime=:endTime and r.isActive=:active")
    public Reservation findReservationByCustomDetails(
            @Param("user_id") User user_id,
            @Param("restaurant_id") Restaurant restaurant_id,
            @Param("startTime") int startTime,
            @Param("endTime") int endTime,
            @Param("active") boolean active);
}

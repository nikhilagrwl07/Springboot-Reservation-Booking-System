package com.nikhil.RestaurantReservation.respository;

import com.nikhil.RestaurantReservation.table.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    Restaurant findByContactNumber(String contactNumber);
}

package com.nikhil.RestaurantReservation.respository;

import com.nikhil.RestaurantReservation.table.Restaurant;
import com.nikhil.RestaurantReservation.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByContactNumber(String contactNumber);
}

package com.nikhil.RestaurantReservation;

import com.nikhil.RestaurantReservation.table.Restaurant;
import com.nikhil.RestaurantReservation.table.User;
import com.nikhil.RestaurantReservation.respository.RestaurantRepository;
import com.nikhil.RestaurantReservation.respository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public DBSeeder(RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        User nikhil = new User("nagrawal@luc.edu", "pass1",
                "Nikhil", "Agrawal", "3126192978");
        User ritu = new User("ragrawal@luc.edu", "pass1",
                "Ritu", "Agrawal", "3126198771");

        List<User> users = new ArrayList<>();
        users.add(nikhil);
        users.add(ritu);

        userRepository.saveAll(users);

        Restaurant khanna = new Restaurant("99999999", "Khanna Paratha Wala", "Addr1", "Addr2",
                1000,2100, 234234234L, 234234234L);

        restaurantRepository.save(khanna);

    }
}

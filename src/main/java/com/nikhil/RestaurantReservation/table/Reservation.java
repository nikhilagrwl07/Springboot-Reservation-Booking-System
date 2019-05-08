package com.nikhil.RestaurantReservation.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"USER_ID", "RESTAURANT_ID", "BOOKING_START_TIME", "BOOKING_END_TIME", "IS_ACTIVE"},
                name = "uk_userId_restaurantId_booking_start_time_booking_end_time_isActive")})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {

    @Id
    @GeneratedValue
    long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    @Column(name = "BOOKING_START_TIME")
    private int startTime;

    @Column(name = "BOOKING_END_TIME")
    private int endTime;

    @Column(name = "IS_ACTIVE", nullable = false, columnDefinition = "boolean default true")
    private boolean isActive = true;

    @Column(name = "NUMBER_OF_PERSON")
    private int numberOfPerson;

    public Reservation(User user, Restaurant restaurant, int startTime, int endTime, int numberOfPerson) {
        this.user = user;
        this.restaurant = restaurant;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfPerson = numberOfPerson;
    }

    public void cancelReservation() {
        this.isActive = false;
        restaurant.freeAvailableTableCount(1);
    }
}

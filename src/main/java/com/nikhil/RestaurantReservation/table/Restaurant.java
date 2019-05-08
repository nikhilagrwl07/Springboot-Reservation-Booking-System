package com.nikhil.RestaurantReservation.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "RESTAURANT")
@AllArgsConstructor
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CONTACT_NUMBER", unique = true, nullable = false)
    private String contactNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "Address1")
    private String address1;

    @Column(name = "Address2")
    private String address2;

    @Column(name = "OPENING_HOUR")
    private int openingHour;

    @Column(name = "CLOSING_HOUR")
    private int closingHour;

    @Column(name = "LATITUDE")
    private Long latitude;

    @Column(name = "LONGITUDE")
    private Long longitude;

    @Column(name = "AVAILABLE_TABLE_COUNT")
    private int availableTableCount;

    public Restaurant() {
    }

    public Restaurant(String contactNumber, String name, String address1, String address2, int openingHour,
                      int closingHour, Long latitude, Long longitude) {
        this.contactNumber = contactNumber;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.latitude = latitude;
        this.longitude = longitude;
        this.availableTableCount = 10;
    }

    public boolean isTableAvailable(int requestedTableCount) {
        boolean result = this.availableTableCount > requestedTableCount;
        blockAvailableTableCount(requestedTableCount);
        return result;
    }

    public void blockAvailableTableCount(int requestedTableCount) {
        this.availableTableCount -= requestedTableCount;
    }

    public void freeAvailableTableCount(int freeTableCount) {
        this.availableTableCount -= freeTableCount;
    }
}

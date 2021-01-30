package com.weather.backend.location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String region;
    private String country;
    private float longitude;
    private float latitude;

    public Location() {
    }

    public Location(String city, String region, String country, float longitude, float latitude) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Optional<String> getRegion() {
        return Optional.ofNullable(region);
    }

    public String getCountry() {
        return country;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }
}

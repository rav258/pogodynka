package com.weather.backend.location;

import com.weather.exception.BadRequestException;

import java.util.List;

public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createLocation(String city, String region, String country, String longitude, String latitude) {
        if (city == null || city.isBlank()) {
            throw new BadRequestException("Nazwa miasta nie może być pusta");
        }
        if (country == null || country.isBlank()) {
            throw new BadRequestException("Nazwa kraju nie może być pusta");
        }
        if (region != null && region.isBlank()) {
            region = null;
        }

        float longitudeValue = 0f;
        float latitudeValue = 0f;
        try {
            longitude = longitude.replaceAll(",", ".");
            latitude = latitude.replaceAll(",", ".");
            longitudeValue = Float.parseFloat(longitude);
            latitudeValue = Float.parseFloat(latitude);
        } catch (NumberFormatException e) {
            throw new BadRequestException("Szerokość i długość geograficzna muszą być liczbami");
        }
        if (longitudeValue > 90 || longitudeValue < -90) {
            throw new BadRequestException("Szerokość geograficzna musi mieścić się w przedziale <-90; 90>");
        }
        if (latitudeValue > 180 || latitudeValue < -180) {
            throw new BadRequestException("Szerokość geograficzna musi mieścić się w przedziale <-180; 180>");
        }

        Location location = new Location(city, region, country, longitudeValue, latitudeValue);
        return locationRepository.save(location);
    }
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

}
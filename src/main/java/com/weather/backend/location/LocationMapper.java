package com.weather.backend.location;

public class LocationMapper {

    LocationDTO asLocationDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setCity(location.getCity());
        locationDTO.setCountry(location.getCountry());
        locationDTO.setLatitude(location.getLatitude());
        locationDTO.setLongitude(location.getLongitude());

        location.getRegion().ifPresent(locationDTO::setRegion);

        return locationDTO;
    }
}

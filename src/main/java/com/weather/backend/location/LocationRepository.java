package com.weather.backend.location;

import java.util.List;

public interface LocationRepository {
    Location save(Location location);
    List<Location> findAll();
}
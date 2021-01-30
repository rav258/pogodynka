package com.weather.backend.location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationRepositoryMock implements LocationRepository {
    private final List<Location> locations = new ArrayList<>();

    @Override
    public Location save(Location location) {
        locations.add(location);
        return location;
    }

    @Override
    public List<Location> findAll() {
        return Collections.unmodifiableList(locations);
    }

    void clear() {
        locations.clear();
    }
}

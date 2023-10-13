package com.skyapi.weatherforecast.common.location;

import com.skyapi.weatherforecast.common.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository repository;

    public Location addLocation(Location location){
        return repository.save(location);
    }

}

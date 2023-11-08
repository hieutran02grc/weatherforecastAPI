package com.skyapi.weatherforecast.common.location;

import com.skyapi.weatherforecast.common.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository repository;

    public Location addLocation(Location location){
        return repository.save(location);
    }

    public List<Location> getUntrashedLocation(){
        return repository.findUntrashed();
    }

    public Location get(String code){
        return repository.findByCode(code);
    }

    public Location update(Location locationInRequest) throws LocationNotFoundException {
        String code = locationInRequest.getCode();

        Optional<Location> locationInDB = repository.findById(code);

        if (locationInDB.isEmpty()){
            throw new LocationNotFoundException("No location found with the given code: " + code);
        }

        Location location = locationInDB.get();

        location.setCityName(locationInRequest.getCityName());
        location.setRegionName(locationInRequest.getRegionName());
        location.setCountryCode(locationInRequest.getCountryCode());
        location.setCityName(locationInRequest.getCountryName());
        location.setEnable(locationInRequest.isEnable());

        return repository.save(location);
    }

}

package com.skyapi.weatherforecast.common.location;

import com.skyapi.weatherforecast.common.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("v1/locations")
public class LocationApiController {
    @Autowired
    LocationService locationService;
    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody Location location){
        Location addedLocation = locationService.addLocation(location);

        URI uri = URI.create("v1/locations/" + location.getCode());

        return ResponseEntity.created(uri).body(addedLocation);
    }
}

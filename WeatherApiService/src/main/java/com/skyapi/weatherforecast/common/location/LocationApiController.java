package com.skyapi.weatherforecast.common.location;

import com.skyapi.weatherforecast.common.Location;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/locations")
public class LocationApiController {
    @Autowired
    LocationService locationService;
    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody @Valid Location location){
        Location addedLocation = locationService.addLocation(location);

        URI uri = URI.create("v1/locations/" + location.getCode());

        return ResponseEntity.created(uri).body(addedLocation);
    }

    @GetMapping()
    public ResponseEntity<List<?>> getListUntrashedLocation(){
        List<Location> listLocation = locationService.getUntrashedLocation();
        if (listLocation.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<>(listLocation, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getLocation(@PathVariable("code") String code){
        Location location = locationService.get(code);

        if (location == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(location);
    }

    @PutMapping
    public ResponseEntity<?> updateLocation(@RequestBody @Valid Location location){
        try {
            Location updatedLocation = locationService.update(location);

            return ResponseEntity.ok(updatedLocation);
        } catch (LocationNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

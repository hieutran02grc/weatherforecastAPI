package com.skyapi.weatherforecast.common.location;

public class LocationNotFoundException extends Exception {
    public LocationNotFoundException(String massage){
        super(massage);
    }
}

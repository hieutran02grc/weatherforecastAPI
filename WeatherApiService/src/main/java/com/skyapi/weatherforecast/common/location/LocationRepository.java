package com.skyapi.weatherforecast.common.location;

import com.skyapi.weatherforecast.common.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, String> {
}
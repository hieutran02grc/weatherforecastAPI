package com.skyapi.weatherforecast.common.location;

import com.skyapi.weatherforecast.common.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, String> {
    @Query("Select l from Location l where l.trashed = false")
    public List<Location> findUntrashed();

    @Query("Select l from Location l where l.trashed = false and l.code = ?1")
    public Location findByCode(String code);
}

package com.travelzer_vehicules.travelzer.dbs;

import com.travelzer_vehicules.travelzer.models.Vehicule;
import org.springframework.data.repository.CrudRepository;

public interface DbVehicule extends CrudRepository<Vehicule, Integer> {
    public String findByModelName(String name);
}

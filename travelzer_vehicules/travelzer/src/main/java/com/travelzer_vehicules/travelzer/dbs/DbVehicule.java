package com.travelzer_vehicules.travelzer.dbs;

import com.travelzer_vehicules.travelzer.models.Vehicule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface DbVehicule extends CrudRepository<Vehicule, Integer> {
    public Iterable<Vehicule> findByModel(String name);
}

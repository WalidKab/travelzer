package com.travelzer_vehicules.travelzer.dbs;

import com.travelzer_vehicules.travelzer.models.Vehicule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DbVehicule extends CrudRepository<Vehicule, Integer>{

    List<Vehicule> findVehiclesByCategory(int id);
}

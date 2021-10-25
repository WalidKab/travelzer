package com.travelzer_vehicules.travelzer.dbs;

import com.travelzer_vehicules.travelzer.models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DbVehicule extends CrudRepository<Vehicule, Integer> , JpaRepository<Vehicule, Integer> {

    @Query("select * from vehicule v where v.category.id like ?1")
    Iterable<Vehicule> findByModel(int id);
}

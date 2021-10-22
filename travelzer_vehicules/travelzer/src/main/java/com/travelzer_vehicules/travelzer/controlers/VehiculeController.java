package com.travelzer_vehicules.travelzer.controlers;

import com.travelzer_vehicules.travelzer.dbs.DbModel;
import com.travelzer_vehicules.travelzer.dbs.DbVehicule;
import com.travelzer_vehicules.travelzer.models.Model;
import com.travelzer_vehicules.travelzer.models.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VehiculeController {

    @Autowired
    private DbVehicule dbVehicule;

    @GetMapping(value = "/vehicules")
    public @ResponseBody
    Iterable<Vehicule> vehiculesList(){
        return dbVehicule.findAll();
    }

    @GetMapping(value = "/vehicule/{id}")
    public Optional<Vehicule> vehiculeById(@PathVariable int id){
        return dbVehicule.findById(id);
    }

    @PostMapping(value = "/vehicule")
    public Vehicule addVehicule(@RequestBody Vehicule vehicule){
        return dbVehicule.save(vehicule);
    }

    @PutMapping(value = "/vehicule/{id}")
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule, @PathVariable int id){
        vehicule.setId(id);
        return dbVehicule.save(vehicule);
    }

    @DeleteMapping(value = "/vehicule/{id}")
    public void deleteVehicule(@PathVariable int id){
        dbVehicule.deleteById(id);
    }
}

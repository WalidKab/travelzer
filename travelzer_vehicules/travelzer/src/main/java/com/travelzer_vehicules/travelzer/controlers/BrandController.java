package com.travelzer_vehicules.travelzer.controlers;

import com.travelzer_vehicules.travelzer.dbs.DbBrand;
import com.travelzer_vehicules.travelzer.models.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BrandController {

    @Autowired
    private DbBrand dbBrand;

    @GetMapping(value = "/brands")
    public @ResponseBody Iterable<Brand> brandList(){
        return dbBrand.findAll();
    }

    @GetMapping(value = "/brand/{id}")
    public Optional<Brand> userById(@PathVariable int id){
        return dbBrand.findById(id);
    }

    @PostMapping(value = "/brand")
    public Brand addUser(@RequestBody Brand user){
        return dbBrand.save(user);
    }

    @PutMapping(value = "/brand/{id}")
    public Brand updateUser(@RequestBody Brand user, @PathVariable int id){
        user.setId(id);
        return dbBrand.save(user);
    }

    @DeleteMapping(value = "/brand/{id}")
    public void deleteUser(@PathVariable int id){
        dbBrand.deleteById(id);
    }
}

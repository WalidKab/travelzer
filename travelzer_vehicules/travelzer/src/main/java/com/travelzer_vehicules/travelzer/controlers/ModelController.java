package com.travelzer_vehicules.travelzer.controlers;

import com.travelzer_vehicules.travelzer.dbs.DbModel;
import com.travelzer_vehicules.travelzer.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ModelController {

    @Autowired
    private DbModel dbModel;

    @GetMapping(value = "/models")
    public @ResponseBody
    Iterable<Model> modelsList(){
        return dbModel.findAll();
    }

    @GetMapping(value = "/model/{id}")
    public Optional<Model> modelById(@PathVariable int id){
        return dbModel.findById(id);
    }

    @PostMapping(value = "/model")
    public Model addModel(@RequestBody Model model){
        return dbModel.save(model);
    }

    @PutMapping(value = "/model/{id}")
    public Model updateModel(@RequestBody Model model, @PathVariable int id){
        model.setId(id);
        return dbModel.save(model);
    }

    @DeleteMapping(value = "/model/{id}")
    public void deleteModel(@PathVariable int id){
        dbModel.deleteById(id);
    }
}

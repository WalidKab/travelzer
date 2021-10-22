package com.travelzer_vehicules.travelzer.controlers;

import com.travelzer_vehicules.travelzer.dbs.DbCategory;
import com.travelzer_vehicules.travelzer.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private DbCategory dbCategory;

    @GetMapping(value = "/categories")
    public @ResponseBody
    Iterable<Category> categoriesList(){
        return dbCategory.findAll();
    }

    @GetMapping(value = "/category/{id}")
    public Optional<Category> categoryById(@PathVariable int id){
        return dbCategory.findById(id);
    }

    @PostMapping(value = "/category")
    public Category addCategory(@RequestBody Category category){
        return dbCategory.save(category);
    }

    @PutMapping(value = "/category/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable int id){
        category.setId(id);
        return dbCategory.save(category);
    }

    @DeleteMapping(value = "/category/{id}")
    public void deleteCategory(@PathVariable int id){
        dbCategory.deleteById(id);
    }
}

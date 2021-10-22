package com.travelzer_vehicules.travelzer.dbs;

import com.travelzer_vehicules.travelzer.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface DbCategory extends CrudRepository<Category, Integer> {
}

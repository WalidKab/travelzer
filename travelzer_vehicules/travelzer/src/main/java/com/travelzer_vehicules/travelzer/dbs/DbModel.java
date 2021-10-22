package com.travelzer_vehicules.travelzer.dbs;

import com.travelzer_vehicules.travelzer.models.Model;
import org.springframework.data.repository.CrudRepository;

public interface DbModel extends CrudRepository<Model, Integer> {
}

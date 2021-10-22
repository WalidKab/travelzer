package com.travelzer_vehicules.travelzer.dbs;

import com.travelzer_vehicules.travelzer.models.Brand;
import org.springframework.data.repository.CrudRepository;

public interface DbBrand extends CrudRepository<Brand, Integer> {
}

package com.travelzer.travelzer.db;

import com.travelzer.travelzer.model.User;
import org.springframework.data.repository.CrudRepository;

public interface DbDao extends CrudRepository<User, Integer> {
}

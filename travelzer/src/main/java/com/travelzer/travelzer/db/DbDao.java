package com.travelzer.travelzer.db;

import com.travelzer.travelzer.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DbDao extends CrudRepository<User, Integer> {
    boolean existsByLicencenumber(String licencenumber);

    Optional<User> getUserByLicencenumber(String string);
}

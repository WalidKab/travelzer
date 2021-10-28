package com.travelzer.travelzer.controller;

import com.travelzer.travelzer.db.DbDao;
import com.travelzer.travelzer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private DbDao dbDao;

    @GetMapping(value = "/users")
    public @ResponseBody Iterable<User> usersList(){
        return dbDao.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public Optional<User> userById(@PathVariable int id){
        return dbDao.findById(id);
    }

    @PostMapping(value = "/user")
    public User addUser(@RequestBody User user){
        return dbDao.save(user);
    }

    @PutMapping(value = "/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id){
        user.setId(id);
        return dbDao.save(user);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable int id){
        dbDao.deleteById(id);
    }

    @GetMapping(value = "/licencenumber/{string}")
    public boolean existByLicenceNumber(@PathVariable String string){
        return dbDao.existsByLicencenumber(string);
    }

    @GetMapping(value = "/getuser/{string}")
    public Optional<User> getUserByLicencenumber(@PathVariable String string){
        return dbDao.getUserByLicencenumber(string);
    }
}

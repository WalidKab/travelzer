package com.travelzer_reservation.travelzer.controllers;

import com.travelzer_reservation.travelzer.dbs.DbReservation;
import com.travelzer_reservation.travelzer.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    private DbReservation dbReservation;

    @GetMapping(value = "/reservations")
    public @ResponseBody
    Iterable<Reservation> reservationsList(){
        return dbReservation.findAll();
    }

    @GetMapping(value = "/reservation/{id}")
    public Optional<Reservation> reservationById(@PathVariable int id){
        return dbReservation.findById(id);
    }

    @PostMapping(value = "/reservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return dbReservation.save(reservation);
    }

    @PutMapping(value = "/reservation/{id}")
    public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable int id){
        reservation.setId(id);
        return dbReservation.save(reservation);
    }

    @DeleteMapping(value = "/reservation/{id}")
    public void deleteReservation(@PathVariable int id){
        dbReservation.deleteById(id);
    }
}

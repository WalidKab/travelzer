package com.travelzer_reservation.travelzer.dbs;

import com.travelzer_reservation.travelzer.models.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DbReservation extends CrudRepository<Reservation, Integer> {

}

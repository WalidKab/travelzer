package com.travelzer_front.travelzer.controllers;

import com.travelzer_front.travelzer.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontController {

    @Value("${server.url.catalogue}")
    private String urlCatalogue;

    @Value("${server.url.users}")
    private String urlUsers;

    @Value("${server.url.reservation}")
    private String urlReservation;

    @GetMapping(value ={"/", "/home"})
    public String index(){
         return "index";
    }

    @GetMapping(value ={"/catalogue"})
    public String catalogue(Model model){
        Vehicule[] vehicules = new RestTemplate().getForObject(urlCatalogue + "/vehicules", Vehicule[].class);
        model.addAttribute("vehiculeList", vehicules);
        return "catalogue";
    }

    @GetMapping(value = "/vehicule/{id}")
    public String showVehicle(Model model, @PathVariable int id){
        Vehicule vehicule = new RestTemplate().getForObject(urlCatalogue + "/vehicule/" + id, Vehicule.class);
        Reservation[] reservations = new RestTemplate().getForObject(urlReservation + "/reservations/" , Reservation[].class);
        List<Reservation> filteredReservation = new ArrayList<>();
        for (Reservation reservation : reservations){
            if(reservation.getVehicule_id() == id){
                filteredReservation.add(reservation);
            }
        }
        model.addAttribute("vehicule", vehicule);
        model.addAttribute("reservations", filteredReservation);
        return "product";
    }

}

package com.travelzer_front.travelzer.controllers;

import com.travelzer_front.travelzer.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class FrontController {

    @Value("${server.url.catalogue}")
    private String urlCatalogue;

    @Value("${server.url.users}")
    private String urlUsers;

    @Value("${server.url.reservation}")
    private String urlReservation;

    @GetMapping(value = {"/", "/home"})
    public String index() {
        return "index";
    }

    @GetMapping(value = {"/catalogue"})
    public String catalogue(Model model) {
        Vehicule[] vehicules = new RestTemplate().getForObject(urlCatalogue + "/vehicules", Vehicule[].class);
        model.addAttribute("vehiculeList", vehicules);
        return "catalogue";
    }

    @GetMapping(value = "/vehicule/{id}")
    public String showVehicle(Model model, @PathVariable int id) {
        Vehicule vehicule = new RestTemplate().getForObject(urlCatalogue + "/vehicule/" + id, Vehicule.class);
        model.addAttribute("vehicule", vehicule);
        return "product";
    }

    @GetMapping(value = "/vehicule/{id}/reserve")
    public String reserveVehicle(Model model, @PathVariable int id) {
        Vehicule vehicule = new RestTemplate().getForObject(urlCatalogue + "/vehicule/" + id, Vehicule.class);
        model.addAttribute("vehicule", vehicule);

        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);

        return "reservation";
    }

    @PostMapping(value = "/vehicule/{id}/reserve")
    public String addReservation(@ModelAttribute("reservation") Reservation reservationForm) {

        boolean userExist = new RestTemplate().getForObject(urlUsers + "/licencenumber/" + reservationForm.getLicenceNumber(), boolean.class);

//        if (!userExist){
//
//        }
        return "reservation";
    }

}

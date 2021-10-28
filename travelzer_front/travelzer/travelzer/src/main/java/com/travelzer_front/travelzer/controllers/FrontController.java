package com.travelzer_front.travelzer.controllers;

import com.travelzer_front.travelzer.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping(value = "/vehicule/{id}/reserve")
    public String reserveVehicle(Model model, @PathVariable int id) {
        Vehicule vehicule = new RestTemplate().getForObject(urlCatalogue + "/vehicule/" + id, Vehicule.class);
        model.addAttribute("vehicule", vehicule);

        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);

        return "reservation";
    }

    @PostMapping(value = "/vehicule/{id}/reserve")
    public String addReservation(@ModelAttribute("reservation") Reservation reservationForm, @ModelAttribute("vehicule") Vehicule vehicule) {

        boolean userExist = new RestTemplate().getForObject(urlUsers + "/licencenumber/" + reservationForm.getLicenceNumber(), boolean.class);

        if (!userExist){
            return "redirect:/user/register";
        }
        else{
            User user = new RestTemplate().getForObject(urlUsers + "/getuser/" + reservationForm.getLicenceNumber(), User.class);
            String a = "test";

            Reservation reservation = new Reservation();
            reservation.setDatestart(reservationForm.getDatestart());
            reservation.setDateend(reservationForm.getDateend());
            reservation.setLicenceNumber(reservationForm.getLicenceNumber());
            reservation.setVehicule_id(vehicule.getId());
            reservation.setEstimatedkm(reservationForm.getEstimatedkm());
            reservation.setUser_id(user.getId());

            new RestTemplate().postForObject(urlReservation + "/reservation", reservation, Reservation.class);

            return "redirect:/catalogue";
        }
    }

//    === Route for User registration

    @GetMapping(value = "/user/register")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user", user );
        return "register";
    }

    @PostMapping(value = "/user/register")
    public String addUser(@ModelAttribute("user") User userForm){
        User user = new User();

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = userForm.getBirthday();

        user.setFirstname(userForm.getFirstname());
        user.setLastname(userForm.getLastname());
        user.setBirthday(userForm.getBirthday());
        user.setEmail(userForm.getEmail());
        user.setPhone(userForm.getPhone());
        user.setPassword(userForm.getPassword());
        user.setLicencenumber(userForm.getLicencenumber());
        user.setLicencedate(userForm.getLicencedate());

        new RestTemplate().postForObject(urlUsers + "/user", user, User.class);

        return "redirect:/catalogue";
    }
}

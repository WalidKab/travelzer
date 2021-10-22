package com.travelzer_front.travelzer.controllers;

import com.travelzer_front.travelzer.models.Vehicule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    @GetMapping(value ={"/", "/home"})
    public String index(Model model){
         Vehicule[] vehicules = new RestTemplate().getForObject("http://localhost:8083/vehicules", Vehicule[].class);
         model.addAttribute("vehiculeList", vehicules);
         return "index";
    }
}

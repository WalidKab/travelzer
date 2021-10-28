package com.travelzer_front.travelzer.controllers;

import com.travelzer_front.travelzer.models.Category;
import com.travelzer_front.travelzer.models.User;
import com.travelzer_front.travelzer.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class DashboardController {

    @Value("${server.url.catalogue}")
    private String urlCatalogue;

    @Value("${server.url.users}")
    private String urlUsers;

    @Value("${server.url.reservation}")
    private String urlReservation;

    final String baseRoute = "/backoffice/dashboard";

    @GetMapping(value = baseRoute)
    public String backoffice(Model model) {

        Vehicule[] vehicules = new RestTemplate().getForObject(urlCatalogue + "/vehicules", Vehicule[].class);
        model.addAttribute("vehiculeList", vehicules);

        User[] users = new RestTemplate().getForObject(urlUsers + "/users", User[].class);
        model.addAttribute("usersList", users);

        Category[] categories = new RestTemplate().getForObject(urlCatalogue + "/categories", Category[].class );
        model.addAttribute("categories",categories);

        com.travelzer_front.travelzer.models.Model[] vehicleModel = new RestTemplate().getForObject(urlCatalogue + "/models", com.travelzer_front.travelzer.models.Model[].class);
        model.addAttribute("models",vehicleModel);

        Brand[] brands = new RestTemplate().getForObject(urlCatalogue + "/brands",Brand[].class);
        model.addAttribute("brands",brands);

        return "backoffice-dashboard";
    }

//    === routes for vehicles

    @GetMapping(value = baseRoute + "/editVehicle/{id}")
    public String showVehicle(@PathVariable int id, Model model) {

        Vehicule vehicule = new RestTemplate().getForObject(urlCatalogue + "/vehicule/" + id, Vehicule.class);
        model.addAttribute("vehicle", vehicule);

        Category[] category = new RestTemplate().getForObject(urlCatalogue + "/categories", Category[].class);
        model.addAttribute("categories", category);

        return "backoffice-editVehicle";
    }

    @PostMapping(value = baseRoute + "/editVehicle/{id}")
    public String editVehicule(@PathVariable int id, @ModelAttribute("vehicle") Vehicule vehicleForm) {

        Vehicule vehicle = new RestTemplate().getForObject(urlCatalogue + "/vehicule/" + id, Vehicule.class);
        vehicle.setColor(vehicleForm.getColor());
        vehicle.setKmcounter(vehicleForm.getKmcounter());
        vehicle.setImage(vehicleForm.getImage());
        vehicle.setMatriculation(vehicleForm.getMatriculation());

        Category category = new RestTemplate().getForObject(urlCatalogue + "/category/" + vehicleForm.getCategory().getId(), Category.class);
        vehicle.setCategory(category);

        new RestTemplate().put(urlCatalogue + "/vehicule/" + vehicle.getId(), vehicle, Vehicule.class);
        return "redirect:/backoffice/dashboard";
    }

    @GetMapping(value = baseRoute + "/addVehicle")
    public String addVehicle(Model model) {

        Vehicule vehicule = new Vehicule();
        model.addAttribute("vehicle", vehicule);

        Category[] category = new RestTemplate().getForObject(urlCatalogue + "/categories", Category[].class);
        model.addAttribute("categories", category);

        com.travelzer_front.travelzer.models.Model[] modelVehicle = new RestTemplate().getForObject(urlCatalogue + "/models", com.travelzer_front.travelzer.models.Model[].class);
        model.addAttribute("models", modelVehicle);

        return "backoffice-addVehicle";
    }

    @PostMapping(value = baseRoute + "/addVehicle")
    public String addVehicle(@ModelAttribute("vehicle") Vehicule vehicleForm) {

        Vehicule vehicule = new Vehicule();

        vehicule.setColor(vehicleForm.getColor());
        vehicule.setMatriculation(vehicleForm.getMatriculation());
        vehicule.setKmcounter(vehicleForm.getKmcounter());
        vehicule.setImage(vehicleForm.getImage());
        vehicule.setPricerate(vehicleForm.getPricerate());

        Category category = new RestTemplate().getForObject(urlCatalogue + "/category/" + vehicleForm.getCategory().getId(), Category.class);
        com.travelzer_front.travelzer.models.Model vehicleModel = new RestTemplate().getForObject(urlCatalogue + "/model/" + vehicleForm.getModel().getId(), com.travelzer_front.travelzer.models.Model.class);

        vehicule.setCategory(category);
        vehicule.setModel(vehicleModel);

        new RestTemplate().postForObject(urlCatalogue + "/vehicule", vehicule, Vehicule.class);

        return "redirect:/backoffice/dashboard";
    }

    //    === routes for Categories

    @GetMapping(value = baseRoute + "/addCategory")
    public String addCategory(Model model) {

        Category category = new Category();
        model.addAttribute("category", category);

        return "backoffice-addCategory";
    }

    @PostMapping(value = baseRoute + "/addCategory")
    public String addCategory(@ModelAttribute("category") Category categoryForm) {

        Category category = new Category();

        category.setName(categoryForm.getName());
        category.setBaseprice(categoryForm.getBaseprice());

        new RestTemplate().postForObject(urlCatalogue + "/category", category, Category.class);

        return "redirect:/backoffice/dashboard";
    }

    @GetMapping(value = baseRoute + "/editCategory/{id}")
    public String showCategory(@PathVariable int id, Model model) {

        Category category = new RestTemplate().getForObject(urlCatalogue + "/category/" + id, Category.class);
        model.addAttribute("category",category);

        return "backoffice-editCategory";
    }

    @PostMapping(value = baseRoute + "/editCategory/{id}")
    public String editCategory(@PathVariable int id, @ModelAttribute("category") Category categoryForm) {

        Category category = new RestTemplate().getForObject(urlCatalogue + "/category/" + id, Category.class);
        category.setName(categoryForm.getName());
        category.setBaseprice(categoryForm.getBaseprice());

        new RestTemplate().put(urlCatalogue + "/category/" + category.getId(), category, Category.class);
        return "redirect:/backoffice/dashboard";
    }


    //    === routes for Brands

    @GetMapping(value = baseRoute + "/addBrand")
    public String addBrand(Model model) {

        Brand brand = new Brand();
        model.addAttribute("brand", brand);

        return "backoffice-addBrand";
    }

    @PostMapping(value = baseRoute + "/addBrand")
    public String addBrand(@ModelAttribute("brand") Brand brandForm) {

        Brand brand = new Brand();

        brand.setName(brandForm.getName());
        brand.setImglogo(brandForm.getImglogo());

        new RestTemplate().postForObject(urlCatalogue + "/brand", brand, Brand.class);

        return "redirect:/backoffice/dashboard";
    }

    @GetMapping(value = baseRoute + "/editBrand/{id}")
    public String editBrand(@PathVariable int id, Model model) {

        Brand brand = new RestTemplate().getForObject(urlCatalogue + "/brand/" + id, Brand.class);
        model.addAttribute("brand",brand);

        return "backoffice-editBrand";
    }

    @PostMapping(value = baseRoute + "/editBrand/{id}")
    public String editBrand(@PathVariable int id, @ModelAttribute("brand") Brand brandForm) {

        Brand brand = new RestTemplate().getForObject(urlCatalogue + "/brand/" + id, Brand.class);
        brand.setName(brandForm.getName());
        brand.setImglogo(brandForm.getImglogo());

        new RestTemplate().put(urlCatalogue + "/brand/" + brand.getId(), brand, Brand.class);
        return "redirect:/backoffice/dashboard";
    }

    @DeleteMapping(value = baseRoute + "/deleteBrand/{id}")
    public String deleteBrand(@PathVariable int id) {

        new RestTemplate().delete(urlCatalogue + "/brand/" + id);
        return "redirect:/backoffice/dashboard";
    }

//    === routes for Model

    @GetMapping(value = baseRoute + "/addModel")
    public String addModel(Model model) {

        com.travelzer_front.travelzer.models.Model vehicleModel = new com.travelzer_front.travelzer.models.Model();
        model.addAttribute("model", vehicleModel);

        Brand[] brands = new RestTemplate().getForObject(urlCatalogue + "/brands", Brand[].class);
        model.addAttribute("brands",brands);

        return "backoffice-addModel";
    }

    @PostMapping(value = baseRoute + "/addModel")
    public String addModel(@ModelAttribute("model") com.travelzer_front.travelzer.models.Model modelForm) {

        com.travelzer_front.travelzer.models.Model vehicleModel = new com.travelzer_front.travelzer.models.Model();

        vehicleModel.setName(modelForm.getName());
        vehicleModel.setSeatcapacity(modelForm.getSeatcapacity());
        vehicleModel.setConsumption(modelForm.getConsumption());
        vehicleModel.setCc(modelForm.getCc());
        vehicleModel.setVolume(modelForm.getVolume());
        vehicleModel.setPriceperkm(modelForm.getPriceperkm());
        vehicleModel.setHorses(modelForm.getHorses());

        Brand brand = new RestTemplate().getForObject(urlCatalogue + "/brand/" + modelForm.getBrand_id().getId(), Brand.class);

        vehicleModel.setBrand_id(brand);

        new RestTemplate().postForObject(urlCatalogue + "/model", vehicleModel, com.travelzer_front.travelzer.models.Model.class);

        return "redirect:/backoffice/dashboard";
    }

    @GetMapping(value = baseRoute + "/editModel/{id}")
    public String editModel(@PathVariable int id, Model model) {

        com.travelzer_front.travelzer.models.Model vehicleModel = new RestTemplate().getForObject(urlCatalogue + "/model/" + id, com.travelzer_front.travelzer.models.Model.class);
        model.addAttribute("model", vehicleModel);

        Brand[] brands = new RestTemplate().getForObject(urlCatalogue + "/brands", Brand[].class);
        model.addAttribute("brands", brands);

        return "backoffice-editModel";
    }

    @PostMapping(value = baseRoute + "/editModel/{id}")
    public String editModel(@PathVariable int id, @ModelAttribute("vehicle") com.travelzer_front.travelzer.models.Model modelForm) {

        com.travelzer_front.travelzer.models.Model vehicleModel = new RestTemplate().getForObject(urlCatalogue + "/model/" + id, com.travelzer_front.travelzer.models.Model.class);
        vehicleModel.setName(modelForm.getName());
        vehicleModel.setSeatcapacity(modelForm.getSeatcapacity());
        vehicleModel.setConsumption(modelForm.getConsumption());
        vehicleModel.setCc(modelForm.getCc());
        vehicleModel.setVolume(modelForm.getVolume());
        vehicleModel.setPriceperkm(modelForm.getPriceperkm());
        vehicleModel.setHorses(modelForm.getHorses());

        Brand brand = new RestTemplate().getForObject(urlCatalogue + "/brand/" + modelForm.getBrand_id().getId(), Brand.class);

        vehicleModel.setBrand_id(brand);

        new RestTemplate().put(urlCatalogue + "/model/" + vehicleModel.getId(), vehicleModel, Model.class);
        return "redirect:/backoffice/dashboard";
    }


}

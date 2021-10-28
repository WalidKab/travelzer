package com.travelzer_front.travelzer.models;

public class Vehicule {

    private int id;

    private float pricerate;

    private int kmcounter;

    private String matriculation;

    private String color;

    private String image;

    private Category category;

    private Model model;

    public Vehicule() {
    }

    public Vehicule(float pricerate, int kmcounter, String matriculation, String color, String image, Category category, Model model) {
        this.pricerate = pricerate;
        this.kmcounter = kmcounter;
        this.matriculation = matriculation;
        this.color = color;
        this.image = image;
        this.category = category;
        this.model = model;
    }

    public Vehicule(int id, float pricerate, int kmcounter, String matriculation, String color, String image, Category category, Model model) {
        this.id = id;
        this.pricerate = pricerate;
        this.kmcounter = kmcounter;
        this.matriculation = matriculation;
        this.color = color;
        this.image = image;
        this.category = category;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPricerate() {
        return pricerate;
    }

    public void setPricerate(float pricerate) {
        this.pricerate = pricerate;
    }

    public int getKmcounter() {
        return kmcounter;
    }

    public void setKmcounter(int kmcounter) {
        this.kmcounter = kmcounter;
    }

    public String getMatriculation() {
        return matriculation;
    }

    public void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }
}

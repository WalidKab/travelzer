package com.travelzer_front.travelzer.models;



public class Brand {


    private int id;

    private String name;

    public String getImglogo() {
        return imglogo;
    }

    public void setImglogo(String imglogo) {
        this.imglogo = imglogo;
    }

    private String imglogo;

    public Brand() {
    }

    public Brand(int id, String name, String imglogo) {
        this.id = id;
        this.name = name;
        this.imglogo = imglogo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

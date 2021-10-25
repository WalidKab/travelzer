package com.travelzer_vehicules.travelzer.models;

import javax.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "imglogo", nullable = false)
    private String imglogo;

    public Brand() {
    }

    public Brand(int id, String name, String imglogo) {
        this.id = id;
        this.name = name;
        this.imglogo = imglogo;
    }

    public String getImglogo() {
        return imglogo;
    }

    public void setImglogo(String imglogo) {
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

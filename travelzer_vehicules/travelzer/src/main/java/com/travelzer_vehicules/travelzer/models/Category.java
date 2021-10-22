package com.travelzer_vehicules.travelzer.models;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "baseprice", nullable = false)
    private float baseprice;

    public Category() {
    }

    public Category(int id, String name, float baseprice) {
        this.id = id;
        this.name = name;
        this.baseprice = baseprice;
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

    public float getBaseprice() {
        return baseprice;
    }

    public void setBaseprice(float baseprice) {
        this.baseprice = baseprice;
    }
}

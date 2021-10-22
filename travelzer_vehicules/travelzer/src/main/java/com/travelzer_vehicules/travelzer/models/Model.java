package com.travelzer_vehicules.travelzer.models;

import javax.persistence.*;

@Entity
@Table(name="model")
public class Model {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "seatcapacity", nullable = false)
    private int seatcapacity;

    @Column(name = "consumption", nullable = false)
    private float consumption;

    @Column(name = "cc")
    private int cc;

    @Column(name = "volume")
    private int volume;

    @Column(name = "priceperkm")
    private float priceperkm;

    @Column(name = "horses", nullable = false)
    private int horses;

    @ManyToOne @JoinColumn(name = "brand_id",nullable = false)
    private Brand brand_id;

    public Model() {
    }

    public Model(int id, String name, int seatcapacity, float consumption, int cc, int volume, float priceperkm, int horses, Brand brand_id) {
        this.id = id;
        this.name = name;
        this.seatcapacity = seatcapacity;
        this.consumption = consumption;
        this.cc = cc;
        this.volume = volume;
        this.priceperkm = priceperkm;
        this.horses = horses;
        this.brand_id = brand_id;
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

    public int getSeatcapacity() {
        return seatcapacity;
    }

    public void setSeatcapacity(int seatcapacity) {
        this.seatcapacity = seatcapacity;
    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public float getPriceperkm() {
        return priceperkm;
    }

    public void setPriceperkm(float priceperkm) {
        this.priceperkm = priceperkm;
    }

    public int getHorses() {
        return horses;
    }

    public void setHorses(int horses) {
        this.horses = horses;
    }

    public Brand getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Brand brand_id) {
        this.brand_id = brand_id;
    }
}

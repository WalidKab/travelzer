package com.travelzer_front.travelzer.models;

public class Model {

    private int id;

    private String name;

    private int seatcapacity;

    private float consumption;

    private int cc;

    private int volume;

    private float priceperkm;

    private int horses;

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

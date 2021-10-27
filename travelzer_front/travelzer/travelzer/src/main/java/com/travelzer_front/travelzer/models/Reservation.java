package com.travelzer_front.travelzer.models;

import java.util.Date;

public class Reservation {
    private int id;

    private Date datestart;

    private Date dateend;

    private int estimatedkm;

    private int realkm;

    private int user_id;

    private int vehicule_id;

    public Reservation() {
    }

    public Reservation(int id, Date datestart, Date dateend, int estimatedkm, int realkm, int user_id, int vehicule_id) {
        this.id = id;
        this.datestart = datestart;
        this.dateend = dateend;
        this.estimatedkm = estimatedkm;
        this.realkm = realkm;
        this.user_id = user_id;
        this.vehicule_id = vehicule_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
        this.dateend = dateend;
    }

    public int getEstimatedkm() {
        return estimatedkm;
    }

    public void setEstimatedkm(int estimatedkm) {
        this.estimatedkm = estimatedkm;
    }

    public int getRealkm() {
        return realkm;
    }

    public void setRealkm(int realkm) {
        this.realkm = realkm;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getVehicule_id() {
        return vehicule_id;
    }

    public void setVehicule_id(int vehicule_id) {
        this.vehicule_id = vehicule_id;
    }
}



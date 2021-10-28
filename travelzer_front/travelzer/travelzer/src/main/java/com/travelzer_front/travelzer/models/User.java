package com.travelzer_front.travelzer.models;

import java.util.Date;

public class User {

    private int id;

    private String firstname;

    private String lastname;

    private Date birthday;

    private String email;

    private String phone;

    private String password;

    private String licencenumber;

    private Date licencedate;

    public User() {
    }

    public User(int id, String firstname, String lastname, Date birthday, String email, String phone, String password, String licencenumber, Date licencedate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.licencenumber = licencenumber;
        this.licencedate = licencedate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLicencenumber() {
        return licencenumber;
    }

    public void setLicencenumber(String licencenumber) {
        this.licencenumber = licencenumber;
    }

    public Date getLicencedate() {
        return licencedate;
    }

    public void setLicencedate(Date licencedate) {
        this.licencedate = licencedate;
    }
}

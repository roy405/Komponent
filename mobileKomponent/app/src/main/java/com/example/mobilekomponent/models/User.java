package com.example.mobilekomponent.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    private Integer id;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String password;
    private String cell_phone;
    private String dob;
    private int userType;


    private List<Orders> orders;

    private Cart cart;

    private List<Payment> payment;

    private List<Address> address;


    public User(Integer id, String first_name, String last_name, String username, String email, String password, String cell_phone, String dob, int userType) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cell_phone = cell_phone;
        this.dob = dob;
        this.userType = userType;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}

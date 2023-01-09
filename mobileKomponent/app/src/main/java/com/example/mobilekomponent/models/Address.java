package com.example.mobilekomponent.models;


public class Address {

    private Integer id;
    private String street1;
    private String street2;
    private String state;
    private String city;
    private String zip_code;
    private String country;
    private String address_type;

    public Address(Integer id, String street1, String street2, String state, String city, String zip_code, String country, String address_type) {
        this.id = id;
        this.street1 = street1;
        this.street2 = street2;
        this.state = state;
        this.city = city;
        this.zip_code = zip_code;
        this.country = country;
        this.address_type = address_type;
    }

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress_type() {
        return address_type;
    }

    public void setAddress_type(String address_type) {
        this.address_type = address_type;
    }
}

package com.example.mobilekomponent.models;


import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

public class Product {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("brand")
    private String brand;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("price")
    private double price;
    @SerializedName("scaledImage")
    private String scaledImage;
    @SerializedName("fullImage")
    private String fullImage;

    public Product(Integer id, String name, String description, String brand, int quantity, double price, String scaledImage, String fullImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
        this.scaledImage = scaledImage;
        this.fullImage = fullImage;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getScaledImage() {
        return scaledImage;
    }

    public void setScaledImage(String scaledImage) {
        this.scaledImage = scaledImage;
    }

    public String getFullImage() {
        return fullImage;
    }

    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }
}

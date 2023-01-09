package com.example.mobilekomponent.models;


public class Payment {

    private Integer id;
    private String payment_method;
    private String card_type;
    private String card_number;
    private String card_expiery;
    private String card_cvv;

    public Payment(Integer id, String payment_method, String card_type, String card_number, String card_expiery, String card_cvv) {
        this.id = id;
        this.payment_method = payment_method;
        this.card_type = card_type;
        this.card_number = card_number;
        this.card_expiery = card_expiery;
        this.card_cvv = card_cvv;
    }

    public Payment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_expiery() {
        return card_expiery;
    }

    public void setCard_expiery(String card_expiery) {
        this.card_expiery = card_expiery;
    }

    public String getCard_cvv() {
        return card_cvv;
    }

    public void setCard_cvv(String card_cvv) {
        this.card_cvv = card_cvv;
    }
}

package com.example.mobilekomponent.models;


import java.util.List;



public class ExteriorSupplier {

    private Integer id;
    private String exterior_supplier_name;
    private String exterior_supplier_description;

    public ExteriorSupplier(Integer id, String exterior_supplier_name, String exterior_supplier_description) {
        this.id = id;
        this.exterior_supplier_name = exterior_supplier_name;
        this.exterior_supplier_description = exterior_supplier_description;
    }

    public ExteriorSupplier() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExterior_supplier_name() {
        return exterior_supplier_name;
    }

    public void setExterior_supplier_name(String exterior_supplier_name) {
        this.exterior_supplier_name = exterior_supplier_name;
    }

    public String getExterior_supplier_description() {
        return exterior_supplier_description;
    }

    public void setExterior_supplier_description(String exterior_supplier_description) {
        this.exterior_supplier_description = exterior_supplier_description;
    }
}

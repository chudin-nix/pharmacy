package com.epam.webapphello.entity;

import java.math.BigDecimal;

public class Medicine {
    public static final String TABLE = "pharmacy";
    private int id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private int dosage;

    public Medicine () {

    }

    public Medicine(String name, BigDecimal price, int quantity, int dosage) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.dosage = dosage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDosage() {
        return dosage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }
}

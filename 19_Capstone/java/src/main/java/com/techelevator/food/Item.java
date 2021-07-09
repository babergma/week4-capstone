package com.techelevator.food;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class Item {
private String name;
private BigDecimal price;
private String code;
private int quantity;
private String category;


    public Item(String name, BigDecimal price, String code, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.quantity = quantity;
        this.category = category;
    }
    public String toString(){
        return code + " " + name + ", $" + price + "\n";
    }

public abstract String displayVendingSlogan();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

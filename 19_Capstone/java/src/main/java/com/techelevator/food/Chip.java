package com.techelevator.food;

import java.math.BigDecimal;

public class Chip extends Item {

    public Chip(String name, BigDecimal price, String code, int quantity, String category) {
        super(name, price, code, quantity, category);
    }

    @Override
    public String displayVendingSlogan() {
        return "Crunch Crunch, Yum!";
    }
}

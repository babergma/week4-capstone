package com.techelevator.food;

import java.math.BigDecimal;

public class Drink extends Item {

    public Drink(String name, BigDecimal price, String code, int quantity, String category) {
        super(name, price, code, quantity, category);
    }

    @Override
    public String displayVendingSlogan() {
        return "Glug Glug, Yum!";
    }
}

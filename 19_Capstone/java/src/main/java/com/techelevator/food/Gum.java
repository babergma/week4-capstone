package com.techelevator.food;

import java.math.BigDecimal;

public class Gum extends Item {

    public Gum(String name, BigDecimal price, String code, int quantity, String category) {
        super(name, price, code, quantity, category);
    }

    @Override
    public String displayVendingSlogan() {
        return "Chew Chew, Yum!";
    }
}

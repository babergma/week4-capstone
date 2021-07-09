package com.techelevator.food;

import java.math.BigDecimal;

public class Candy extends Item {

    public Candy(String name, BigDecimal price, String code, int quantity, String category) {
        super(name, price, code, quantity, category);
    }


    @Override
    public String displayVendingSlogan() {
        return "Munch Munch, Yum!";
    }
}

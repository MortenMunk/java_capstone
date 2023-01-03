package com.main;

import java.util.Date;

public abstract class Expirables extends Product {

    public Expirables(String name, int stockLeft, double price, Category category) {
        super(name, stockLeft, price, category);
    }
}

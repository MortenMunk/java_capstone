package com.main;

import java.util.Date;

public abstract class Expirables extends Product {

    public Expirables(int id ,String name, double price, Category category) {
        super(id, name, price, category);
    }
}

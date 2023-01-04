package com.main;

import com.main.exceptions.StockCannotBeNegativeException;

import java.util.ArrayList;

public abstract class Product extends Shop {
    private final Category category;
    private int id;
    private final String name;
    private double price;

    public enum Category {
        EDIBLES, CUTLERY, BEVERAGES,
    }

    public Product(int id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

}
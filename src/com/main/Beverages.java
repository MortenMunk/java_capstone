package com.main;

public class Beverages extends Product{

    public Beverages(String name, int stockLeft, double price) {
        super(name, stockLeft, price, Category.BEVERAGES);
    }
}

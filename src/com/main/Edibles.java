package com.main;

public class Edibles extends Product {
    public Edibles(String name, int stockLeft, double price) {
        super(name, stockLeft, price, Category.EDIBLES);
    }
}

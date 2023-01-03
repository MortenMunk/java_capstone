package com.main;

public class Edibles extends Expirables {
    public Edibles(String name, int stockLeft, double price) {
        super(name, stockLeft, price, Category.EDIBLES);
    }
}

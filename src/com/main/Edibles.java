package com.main;

public class Edibles extends Expirables {
    public Edibles(int id, String name, double price) {
        super(id, name, price, Category.EDIBLES);
    }
}

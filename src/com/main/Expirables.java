//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package com.main;

public abstract class Expirables extends Product {

    public Expirables(int id ,String name, double price, Category category) {
        super(id, name, price, category);
    }

    // TODO: expiration implementation for edibles and beverages.
}

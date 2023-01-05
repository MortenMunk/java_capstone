//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package com.main.exceptions;

public class ProductNotFoundException extends RuntimeException {
    private int id;

    public ProductNotFoundException(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}

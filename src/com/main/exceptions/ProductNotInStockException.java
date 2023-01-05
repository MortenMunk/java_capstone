//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package com.main.exceptions;

public class ProductNotInStockException extends RuntimeException {
    private int id;

    public ProductNotInStockException(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}

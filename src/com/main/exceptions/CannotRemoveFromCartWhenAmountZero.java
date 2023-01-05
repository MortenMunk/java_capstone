//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package com.main.exceptions;

public class CannotRemoveFromCartWhenAmountZero extends RuntimeException {
    private int id;

    public CannotRemoveFromCartWhenAmountZero(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}

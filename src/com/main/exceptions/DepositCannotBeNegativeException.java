//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package com.main.exceptions;

public class DepositCannotBeNegativeException extends RuntimeException {
    private double deposit;

    public DepositCannotBeNegativeException(double deposit) {
        this.deposit = deposit;
    }

    public double getDeposit() {
        return deposit;
    }
}

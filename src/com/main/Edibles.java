//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package com.main;

public class Edibles extends Expirables {
    public Edibles(int id, String name, double price) {
        super(id, name, price, Category.EDIBLES);
    }
}

//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package com.main;

import java.util.ArrayList;

public class Shop {

    public ArrayList<CartItem> items = new ArrayList<>();


    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void addProduct(int amount, Product product) {
        this.getItems().add(new CartItem(product, amount));
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> list = new ArrayList<>();
        for (CartItem item : this.getItems()) {
            list.add(item.getProduct());
        }
        return list;
    }
}

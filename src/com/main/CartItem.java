//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package com.main;

import com.main.exceptions.CannotRemoveFromCartWhenAmountZero;

public class CartItem extends ShoppingCart {
    private Product product;

    private int amount;

    public CartItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public void removeAmount(int amount) {
        if(this.amount > 0) {
            this.amount -= amount;
        } else {
            throw new CannotRemoveFromCartWhenAmountZero(amount);
        }
    }
}

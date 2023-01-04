//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package com.main;

import com.main.exceptions.ProductNotFoundException;
import com.main.exceptions.ProductNotInStockException;

import java.util.ArrayList;

public class ShoppingCart {

    private Shop shop;
    public ArrayList<CartItem> cartItems = new ArrayList<>();

    public ShoppingCart() {
    }

    public boolean IsItemAlreadyInCart(int idInput) {
        for (CartItem cartItem : cartItems) {
            if (idInput == cartItem.getProduct().getId()) {
                return true;
            }
        }
        return false;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void addToCart(int idToAdd) {
        for (CartItem item : shop.getItems()) {
            if (item.getProduct().getId() == idToAdd && !IsItemAlreadyInCart(idToAdd)) {
                if(shop.getItems().get(shop.getProducts().indexOf(item.getProduct())).getAmount() > 0) {
                    CartItem newCartItem = new CartItem(item.getProduct(), 1);
                    cartItems.add(newCartItem);
                    item.removeAmount(1);
                    return;
                } else {
                    throw new ProductNotInStockException(idToAdd);
                }
            } else if (item.getProduct().getId() == idToAdd) {
                if(shop.getItems().get(shop.getProducts().indexOf(item.getProduct())).getAmount() > 0) {
                    this.getCartItems().get(this.getProducts().indexOf(item.getProduct())).addAmount(1);
                    item.removeAmount(1);
                    return;
                } else {
                    throw new ProductNotInStockException(idToAdd);
                }
            }
        }
        throw new ProductNotFoundException(idToAdd);
    }

    public void removeFromCart(int idToAdd) {
        for (CartItem item : shop.getItems()) {
            if (item.getProduct().getId() == idToAdd && IsItemAlreadyInCart(idToAdd)) {
                if (shop.getItems().get(shop.getProducts().indexOf(item.getProduct())).getAmount() == 1) {
                    this.getCartItems().remove(this.getProducts().indexOf(item.getProduct()));
                    item.addAmount(1);
                } else if (item.getProduct().getId() == idToAdd) {
                    this.getCartItems().get(this.getProducts().indexOf(item.getProduct())).removeAmount(1);
                    item.addAmount(1);
                    return;
                }
            }
        }
        throw new ProductNotFoundException(idToAdd);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem cartItem : cartItems) {
            totalPrice += cartItem.getProduct().getPrice() * cartItem.getAmount();
        }
        return totalPrice;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> list = new ArrayList<>();
        for (CartItem item : this.getCartItems()) {
            list.add(item.getProduct());
        }
        return list;
    }
}



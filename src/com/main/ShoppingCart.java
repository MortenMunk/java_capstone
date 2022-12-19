package com.main;

import java.util.ArrayList;

import static com.main.Product.products;

public class ShoppingCart {
    public static ArrayList<ShoppingCart> cartItems = new ArrayList<>();

    int cartID;
    String name;
    static int amount;
    double price;

    public ShoppingCart(int cartID, String name, int amount, double price) {
        this.cartID = cartID;
        this.name = name;
        this.amount = amount;
        this.price = price;
        cartItems.add(this);
    }

    public static boolean IsItemAlreadyInCart(int idInput) {
        for (ShoppingCart cartItem : cartItems) {
            if (idInput == cartItem.cartID) {
                return true;
            }
        }
        return false;
    }

    public static void displayProductsInCart() {
        System.out.println("");
        System.out.println("--- YOUR SHOPPING CART ---");
        for (ShoppingCart cartItem : cartItems) {
            if(cartItem.amount < 1) {
                cartItems.remove(cartItem);
            } else {
                System.out.println("#" + cartItem.cartID + ". " + cartItem.name + " --- Amount: " + amount + " --- Price: " + cartItem.price);
            }
        }
    }

    public void addOneAmountToCart() {
        amount += 1;
    }

    public static void removeOneAmountFromCart() { amount -= 1; }

    public static void addToCart(int idToAdd) {
        for (Product product : products) {
            if(product.getId() == idToAdd && !IsItemAlreadyInCart(idToAdd)) {
                new ShoppingCart(product.getId(), product.getName(), 1, product.getPrice());
                product.removeOneStock();
                break;

            } else if (product.getId() == idToAdd && IsItemAlreadyInCart(idToAdd)) {
                for(ShoppingCart cartItem : cartItems) {
                    if(cartItem.cartID == product.getId()) {
                        cartItem.addOneAmountToCart();
                        break;
                    }
                }
                product.removeOneStock();
            }
        }
        System.out.println("COULD NOT FIND ITEM WITH THIS ID");
    }

    public static void removeFromCart(int idToAdd) {
        for (Product product : products) {
            if(product.getId() == idToAdd && IsItemAlreadyInCart(idToAdd)) {
                removeOneAmountFromCart();
            }
        }
        System.out.println("CANNOT FIND ITEM IN CART");
    }
}


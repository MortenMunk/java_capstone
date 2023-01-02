package com.main;

import java.util.ArrayList;
import java.util.Iterator;

import static com.main.Product.products;

public class ShoppingCart {
    public static ArrayList<ShoppingCart> cartItems = new ArrayList<>();

    public int cartID;
    public String name;
    public int amount;
    public double price;

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
        System.out.println();
        System.out.println("--- YOUR SHOPPING CART ---");
        Iterator<ShoppingCart> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            ShoppingCart cartItem = iterator.next();
            if (cartItem.amount < 1) {
                iterator.remove();
            } else {
                System.out.println("#" + cartItem.cartID + ". " + cartItem.name + " --- Amount: " + cartItem.amount + " --- Price pr. item: " + cartItem.price + " --- Total: " + cartItem.amount * cartItem.price + " DKK");
            }
        }
    }

    public static void addToCart(int idToAdd) {
        boolean found = false;
        for (Product product : products) {
            if (product.getId() == idToAdd && !IsItemAlreadyInCart(idToAdd)) {
                new ShoppingCart(product.getId(), product.getName(), 1, product.getPrice());
                product.removeOneStock();
                found = true;
                break;

            } else if (product.getId() == idToAdd && IsItemAlreadyInCart(idToAdd)) {
                for (ShoppingCart cartItem : cartItems) {
                    if (cartItem.cartID == product.getId()) {
                        cartItem.amount += 1;
                        found = true;
                        break;
                    }
                }
                product.removeOneStock();
            }
        }
        if (found == false) {
            System.out.println("PRODUCT NOT FOUND");
        }
    }

    public static void removeFromCart(int idToAdd) {
        boolean found = false;
        for (Product product : products) {
            if (product.getId() == idToAdd && IsItemAlreadyInCart(idToAdd)) {
                for (ShoppingCart cartItem : cartItems) {
                    if (cartItem.cartID == idToAdd && cartItem.amount < 1) {
                        System.out.println("AMOUNT CANNOT BE LESS THAN 0");
                        found = true;
                        break;
                    } else if (cartItem.cartID == idToAdd && cartItem.amount > 0) {
                        cartItem.amount -= 1;
                        product.addOneStock();
                        found = true;
                        break;
                    }
                }
            }
        }
        if (found == false) {
            System.out.println("PRODUCT NOT FOUND IN CART OR SHOP");
        }
    }
}



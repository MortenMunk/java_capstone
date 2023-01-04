package com.main;

import com.main.exceptions.CannotRemoveFromCartWhenAmountZero;
import com.main.exceptions.ProductNotFoundException;
import com.main.exceptions.ProductNotInStockException;

import java.util.ArrayList;
import java.util.Iterator;

import static com.main.Product.products;

public class ShoppingCart {
    public static ArrayList<ShoppingCart> cartItems = new ArrayList<>();

    private int cartID;
    private String name;
    private int amount;
    private double price;

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
                System.out.println("#" + cartItem.cartID + ". " + cartItem.name + " --- Amount: " + cartItem.amount + " --- Price pr. item: " + cartItem.price + " DKK" + " --- Total: " + cartItem.amount * cartItem.price + " DKK");
            }
        }
    }

    public static void addToCart(int idToAdd) {
        for (Product product : products) {
            if (product.getId() == idToAdd && !IsItemAlreadyInCart(idToAdd)) {
                if(product.isInStock()) {
                    new ShoppingCart(product.getId(), product.getName(), 1, product.getPrice());
                    product.removeOneStock();
                    return;
                } else if(!product.isInStock()) {
                    throw new ProductNotInStockException(idToAdd);
                }
            } else if (product.getId() == idToAdd && IsItemAlreadyInCart(idToAdd)) {
                for (ShoppingCart cartItem : cartItems) {
                    if (cartItem.cartID == product.getId() && product.isInStock()) {
                        product.removeOneStock();
                        cartItem.amount += 1;
                        return;
                    } else if (cartItem.cartID == product.getId() && !product.isInStock()) {
                        throw new ProductNotInStockException(idToAdd);
                    }
                }
            }
        }
        throw new ProductNotFoundException(idToAdd);
    }

    public static void removeFromCart(int idToAdd) {
        for (Product product : products) {
            if (product.getId() == idToAdd && IsItemAlreadyInCart(idToAdd)) {
                for (ShoppingCart cartItem : cartItems) {
                    if (cartItem.cartID == idToAdd && cartItem.amount < 1) {
                        throw new CannotRemoveFromCartWhenAmountZero(idToAdd);
                    } else if (cartItem.cartID == idToAdd) {
                        cartItem.amount -= 1;
                        product.addOneStock();
                        return;
                    }
                }
            }
        }
        throw new ProductNotFoundException(idToAdd);
    }

    public static double getTotalPrice() {
        double totalPrice = 0;
        for (ShoppingCart cartItem : cartItems) {
            totalPrice += cartItem.price * cartItem.amount;
        }
        return totalPrice;
    }
}



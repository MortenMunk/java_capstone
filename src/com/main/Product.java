package com.main;

import java.util.ArrayList;

public abstract class Product {
    private final Category category;
    private int id;
    private final String name;
    private int stockLeft;
    private double price;

    public enum Category {
        EDIBLES, CUTLERY, BEVERAGES, UNASSIGNED
    }

    public static ArrayList<Product> products = new ArrayList<>();

    public Product(String name, int stockLeft, double price, Category category) {
        this.name = name;
        this.stockLeft = stockLeft;
        this.price = price;
        this.category = category;
        products.add(this);
    }

    public String getName() {
        return name;
    }

    public int getStockLeft() {
        return stockLeft;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStockLeft(int stockLeft) {
        if (stockLeft >= 0) {
            this.stockLeft = stockLeft;
        } else {
            String msg = "Stock cannot be negative";
            throw new IllegalArgumentException(msg);
        }
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        if (this.stockLeft <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public Category getCategory() {
        return category;
    }

    public static void SetProductsId() {
        int i = 1;
        for (Product product : products) {
            product.setId(i);
            i++;
        }
    }

    public void removeOneStock() {
        stockLeft -= 1;
    }

    public void addOneStock() {
        stockLeft += 1;
    }

    public static void DisplayProducts() {
        for (Product product : products) {
            if (product.isInStock()) {
                System.out.print("#" + product.id + ". ");
                System.out.print(product.name + " --- ");
                System.out.print("Price: " + product.price + " DKK --- ");
                System.out.print("Stock: " + product.stockLeft + " --- ");
                System.out.print("Category: " + product.category);
                System.out.println("");
            } else {
                System.out.print("#" + product.id + ". " + product.name + " ---  OUT OF STOCK! ---");
                System.out.println("");
            }
        }
        System.out.println("--------------------");
        System.out.println("Type the following to perform action:");
        System.out.println("add <ID>: to add a product to your cart");
        System.out.println("remove <ID>: to remove a product from your cart");
        System.out.println("clear: to remove all items from your cart");
        System.out.println("buy: to complete your purchase");
    }
}
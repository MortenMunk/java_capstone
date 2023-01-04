package com.main;

import com.main.exceptions.StockCannotBeNegativeException;

import java.util.ArrayList;

public class Shop {

    public ArrayList<CartItem> items = new ArrayList<>();

    /*public int getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(int stockLeft) {
        if (stockLeft >= 0) {
            this.stockLeft = stockLeft;
        } else {
            throw new StockCannotBeNegativeException();
        }
    }

    public boolean isInStock() {
        return this.stockLeft > 0;
    }

    public void removeOneStock() {
        stockLeft -= 1;
    }

    public void addOneStock() {
        stockLeft += 1;
    }*/

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

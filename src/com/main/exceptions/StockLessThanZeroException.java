package com.main.exceptions;

public class StockLessThanZeroException extends RuntimeException{
    private int stock;

    public StockLessThanZeroException(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
}

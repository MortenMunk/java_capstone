package psvm;

import com.main.*;

public class Main {
    public static void main(String[] args) {

        boolean notDoneShopping = true;

        // BEVERAGE LIST
        Beverages cola = new Beverages("Cola", 15, 15.99, Product.Category.BEVERAGES);
        Beverages fanta = new Beverages("Fanta", 8, 13.99, Product.Category.BEVERAGES);
        Beverages sprite = new Beverages("Sprite", 20, 15.99, Product.Category.BEVERAGES);
        Beverages sevenUp = new Beverages("7-Up", 0, 10.99, Product.Category.BEVERAGES);

        // CUTLERY LIST
        Cutlery spoon = new Cutlery("Spoon", 10, 0.99, Product.Category.CUTLERY);
        Cutlery fork = new Cutlery("Fork", 16, 0.99, Product.Category.CUTLERY);
        Cutlery napkin = new Cutlery("Napkin", 59, 0, Product.Category.CUTLERY);

        // EDIBLE LIST
        Edibles pizza = new Edibles("Pizza", 5, 18, Product.Category.EDIBLES);
        Edibles sandwich = new Edibles("Sandwich", 10, 30, Product.Category.EDIBLES);
        Edibles salad = new Edibles("Salad", 20, 28, Product.Category.EDIBLES);

        Product.SetProductsId();
        Product.DisplayProducts();
        ShoppingCart.addToCart(1);
        ShoppingCart.addToCart(1);
        ShoppingCart.displayProductsInCart();
        Product.DisplayProducts();
        while(notDoneShopping) {

        }
    }
}
package psvm;

import com.main.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean notDoneShopping = true;
        User user = new User("Morten", 0);
        // BEVERAGE LIST
        Beverages cola = new Beverages("Cola", 15, 15.99);
        Beverages fanta = new Beverages("Fanta", 8, 13.99);
        Beverages sprite = new Beverages("Sprite", 20, 15.99);
        Beverages sevenUp = new Beverages("7-Up", 0, 10.99);

        // CUTLERY LIST
        Cutlery spoon = new Cutlery("Spoon", 10, 0.99);
        Cutlery fork = new Cutlery("Fork", 16, 0.99);
        Cutlery napkin = new Cutlery("Napkin", 59, 0);

        // EDIBLE LIST
        Edibles pizza = new Edibles("Pizza", 5, 18);
        Edibles sandwich = new Edibles("Sandwich", 10, 30);
        Edibles salad = new Edibles("Salad", 20, 28);

        Product.SetProductsId();
        while(notDoneShopping) {
            Product.DisplayProducts();
            ShoppingCart.displayProductsInCart();
            System.out.println("Balance: " + user.getBalance() + " DKK");
            System.out.println("--------------------");
            Scanner firstInput = new Scanner(System.in);
            System.out.println("To deposit money, type: d");
            System.out.println("To add product to your cart, type: a");
            System.out.println("To remove product from your cart, type: r");
            System.out.println("To complete purchase, type: p");
            System.out.println("To cancel order, type: c");

            String action = firstInput.nextLine();
            System.out.println(user.getBalance());
            if(action.equals("d")) {
                System.out.println("Please input the amount you want to deposit");
                action = firstInput.nextLine();
                user.deposit(Double.parseDouble(action));
            } else if (action.equals("a")) {
                System.out.println("Please input the ID of the product, you want to add");
                action = firstInput.nextLine();
                ShoppingCart.addToCart(Integer.parseInt(action));
            } else if (action.equals("r")) {
                System.out.println("Please input the ID of the product, you want to remove");
                action = firstInput.nextLine();
                ShoppingCart.removeFromCart(Integer.parseInt(action));
            } else if (action.equals("p")) {
                System.out.println("Purchase completed!");
                user.billAmount(ShoppingCart.getTotalPrice());
                System.out.println("Total billing amount: " + ShoppingCart.getTotalPrice() + " DKK");
                notDoneShopping = false;
            } else if (action.equals("c")) {
                System.out.println("Order cancelled!");
                notDoneShopping = false;
            } else {
                System.out.println("Incorrect input, try again.");
            }
        }
    }
}
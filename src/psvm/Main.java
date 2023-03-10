//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

package psvm;

import com.main.*;
import com.main.exceptions.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Check if the input can be parsed to double
    public static double CheckDouble(String input) {
        double output;
        try {
            output = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(input + " is not a double. Please only input doubles, after the action");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println();
            return 0;
        }
        return output;
    }

    // Checks if the input can be parsed to integer
    public static int CheckInt(String input) {
        int output;
        try {
            output = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(input + " is not an integer. Please only input integers, after the action");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println();
            return -1;
        }
        return output;
    }

    public static void displayProductsInCart(ArrayList<CartItem> itemList) {
        System.out.println();
        System.out.println("--- YOUR SHOPPING CART ---");
        for (CartItem item : itemList) {
            System.out.println("#" + item.getProduct().getId() + ". " + item.getProduct().getName() + " --- Amount: " + item.getAmount() + " --- Price pr. item: " + item.getProduct().getPrice() + " DKK" + " --- Total: " + item.getAmount() * item.getProduct().getPrice() + " DKK");
        }
    }

    public static void DisplayProducts(ArrayList<CartItem> itemList) {
        System.out.println("--------------------");
        for (CartItem item : itemList) {
            if (item.getAmount() > 0) {
                System.out.print("#" + item.getProduct().getId() + ". ");
                System.out.print(item.getProduct().getName() + " --- ");
                System.out.print("Price: " + item.getProduct().getPrice() + " DKK --- ");
                System.out.print("Stock: " + item.getAmount() + " --- ");
                System.out.print("Category: " + item.getProduct().getCategory());
                System.out.println();
            } else {
                System.out.print("#" + item.getProduct().getId() + ". " + item.getProduct().getName() + " ---  OUT OF STOCK! ---");
                System.out.println();
            }
        }
        System.out.println("--------------------");
    }
    public static void main(String[] args) {

        ShoppingCart shoppingCart = new ShoppingCart();
        Shop shop = new Shop();
        shoppingCart.setShop(shop);

        boolean notDoneShopping = true;
        User user = new User("Morten", 0);
        // BEVERAGE LIST
        Beverages cola = new Beverages(1 ,"Cola", 15.99);
        shop.addProduct(2, cola);
        Beverages fanta = new Beverages(2, "Fanta", 13.99);
        shop.addProduct(5, fanta);
        Beverages sprite = new Beverages(3,"Sprite", 15.99);
        shop.addProduct(3, sprite);
        Beverages sevenUp = new Beverages(4,"7-Up", 10.99);
        shop.addProduct(10, sevenUp);

        // CUTLERY LIST
        Cutlery spoon = new Cutlery(5,"Spoon", 0.99);
        shop.addProduct(2, spoon);
        Cutlery fork = new Cutlery(6,"Fork", 0.99);
        shop.addProduct(3, fork);
        Cutlery napkin = new Cutlery(7,"Napkin", 0);
        shop.addProduct(0, napkin);

        // EDIBLE LIST
        Edibles pizza = new Edibles(8,"Pizza", 18.99);
        shop.addProduct(0, pizza);
        Edibles sandwich = new Edibles(9,"Sandwich", 30.99);
        shop.addProduct(10, sandwich);
        Edibles salad = new Edibles(10,"Salad", 28.99);
        shop.addProduct(5, salad);


        while(notDoneShopping) {
            DisplayProducts(shop.getItems());
            System.out.println("To deposit money, type: d");
            System.out.println("To add product to your cart, type: a");
            System.out.println("To remove product from your cart, type: r");
            System.out.println("To complete purchase, type: p");
            System.out.println("To cancel order, type: c");
            displayProductsInCart(shoppingCart.getCartItems());
            System.out.println("Balance: " + user.getBalance() + " DKK");
            System.out.println("--------------------");

            Scanner firstInput = new Scanner(System.in);
            String action = firstInput.nextLine();
            switch (action) {
                // Press d to deposit money
                case "d" -> {
                    System.out.println("Please input the amount you want to deposit");
                    action = firstInput.nextLine();
                    try {
                        user.deposit(CheckDouble(action));
                    } catch (DepositCannotBeNegativeException e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Deposit amount cannot be negative! " + e.getDeposit() + " is a negative amount!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    }
                }
                // Press a to add an item to cart
                case "a" -> {
                    System.out.println("Please input the ID of the product, you want to add");
                    action = firstInput.nextLine();
                    try {
                        shoppingCart.addToCart(CheckInt(action));
                    } catch (ProductNotFoundException e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Product with ID: " + e.getID() + " was not found in shop");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    } catch (ProductNotInStockException e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Cannot add products that are not in stock! Product with ID: " + e.getID() + " is not in stock!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    }
                }
                // Press r to remove item from cart
                case "r" -> {
                    System.out.println("Please input the ID of the product, you want to remove");
                    action = firstInput.nextLine();
                    try {
                        shoppingCart.removeFromCart(CheckInt(action));
                    } catch (CannotRemoveFromCartWhenAmountZero e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Cannot remove product with ID: " + e.getID() + "As the amount cannot be zero or less");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    } catch (ProductNotFoundException e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Product with ID: " + e.getID() + " was not found in shop or in cart!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    }
                }
                // Press p to complete purchase
                case "p" -> {
                    System.out.println("Purchase completed!");
                    try {
                        user.billAmount(shoppingCart.getTotalPrice());
                        System.out.println("Total billing amount: " + shoppingCart.getTotalPrice() + " DKK");
                        notDoneShopping = false; // end the program after the transaction is complete
                    } catch (BalanceCannotBeNegativeException e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Balance cannot be negative, " + e.getBalance() + " DKK will make the balance negative!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    } catch (DepositCannotBeNegativeException e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Deposit input cannot be negative! " + e.getDeposit() + " DKK is a negative value!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    } catch (CannotBillWithNoChargeException e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Cannot bill, without any charges!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    } catch (BillingAmountCannotExceedBalanceException e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Billing amount cannot exceed balance! " + e.getBillAmount() + "DKK is more than " + e.getBalance() + " DKK");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    }
                }
                // Press c to cancel order
                case "c" -> {
                    System.out.println("Order cancelled!");
                    notDoneShopping = false; // end the program
                }
                default -> {
                    try {
                        user.invalidInput(); // throw an exception, but continue the program
                    } catch (InvalidActionInputException e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Invalid input! Please use only suggested inputs!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    }
                }
            }
        }
    }
}
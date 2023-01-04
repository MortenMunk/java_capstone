package psvm;

import com.main.*;
import com.main.exceptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean notDoneShopping = true;
        User user = new User("Morten", 0);
        // BEVERAGE LIST
        Beverages cola = new Beverages("Cola", 2, 15.99);
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
        Product.DisplayProducts();
        System.out.println("To deposit money, type: d");
        System.out.println("To add product to your cart, type: a");
        System.out.println("To remove product from your cart, type: r");
        System.out.println("To complete purchase, type: p");
        System.out.println("To cancel order, type: c");
        while(notDoneShopping) {
            ShoppingCart.displayProductsInCart();
            System.out.println("Balance: " + user.getBalance() + " DKK");
            System.out.println("--------------------");
            Scanner firstInput = new Scanner(System.in);

            String action = firstInput.nextLine();
            System.out.println(user.getBalance());
            switch (action) {
                case "d" -> {
                    System.out.println("Please input the amount you want to deposit");
                    action = firstInput.nextLine();
                    try {
                        user.deposit(Double.parseDouble(action));
                    } catch (DepositCannotBeNegativeException e) {
                        System.out.println();
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Deposit amount cannot be negative! " + e.getDeposit() + " is a negative amount!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println();
                    }
                }
                case "a" -> {
                    System.out.println("Please input the ID of the product, you want to add");
                    action = firstInput.nextLine();
                    try {
                        ShoppingCart.addToCart(Integer.parseInt(action));
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
                case "r" -> {
                    System.out.println("Please input the ID of the product, you want to remove");
                    action = firstInput.nextLine();
                    try {
                        ShoppingCart.removeFromCart(Integer.parseInt(action));
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
                case "p" -> {
                    System.out.println("Purchase completed!");
                    try {
                        user.billAmount(ShoppingCart.getTotalPrice());
                        System.out.println("Total billing amount: " + ShoppingCart.getTotalPrice() + " DKK");
                        notDoneShopping = false;
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
                case "c" -> {
                    System.out.println("Order cancelled!");
                    notDoneShopping = false;
                }
                default -> {
                    try {
                        user.invalidInput();
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
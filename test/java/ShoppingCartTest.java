//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

import com.main.*;
import com.main.exceptions.ProductNotFoundException;
import com.main.exceptions.ProductNotInStockException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    ShoppingCart shoppingCartTest = new ShoppingCart();
    Shop shopTest;
    Shop shopTest1;
    Shop shopTest2;
    Beverages cola;
    Beverages fanta;
    ShoppingCart shoppingCartTest1 = new ShoppingCart();
    ShoppingCart shoppingCartTest2 = new ShoppingCart();
    ArrayList<CartItem> cartItemsTest;

    @BeforeEach()
    void BeforeEach() {
        shopTest = new Shop();
        shopTest1 = new Shop();
        shopTest2 = new Shop();
        cola = new Beverages(1 ,"Cola", 15.99);
        fanta = new Beverages(2 ,"Fanta", 15.99);
        shopTest.addProduct(4, cola);
        cartItemsTest = new ArrayList<>();
        shoppingCartTest.setShop(shopTest);
        shoppingCartTest1.setShop(shopTest1);
        shoppingCartTest2.setShop(shopTest2);
        shoppingCartTest.addToCart(1);
    }

    @Test
    void TestGetCartItems() {
        assertEquals(shoppingCartTest1.getCartItems(), shoppingCartTest2.getCartItems());
    }

    @Test
    void TestGetProducts() {
        assertEquals(shoppingCartTest1.getProducts(), shoppingCartTest2.getProducts());
    }

    @Test
    void TestAddToCart() {
        shoppingCartTest.addToCart(1);
        for (CartItem cartItemTest : cartItemsTest){
            if(cartItemTest.getProduct().getId() == 1) {
                assertEquals(2, cartItemTest.getAmount());
            }
        }
    }

    @Test
    void TestIsAlreadyInCart() {
        assertTrue(shoppingCartTest.IsItemAlreadyInCart(1));
        assertFalse(shoppingCartTest1.IsItemAlreadyInCart(1));
    }

    @Test
    void TestProductNotFoundException() {
        assertThrows(ProductNotFoundException.class, ()->
            shoppingCartTest2.addToCart(200));
    }

    @Test
    void TestGetTotalPrice() {
        shoppingCartTest.addToCart(1);
        assertEquals(cola.getPrice()*2, shoppingCartTest.getTotalPrice());
    }

    @Test
    void TestProductNotInStockException() {
        shopTest1.addProduct(0, cola);
        assertThrows(ProductNotInStockException.class, ()->
                shoppingCartTest1.addToCart(1));
    }

    @Test
    void TestRemoveFromCart() {
        shoppingCartTest.removeFromCart(1);
        for (CartItem cartItemTest : cartItemsTest){
            if(cartItemTest.getProduct().getId() == 1) {
                assertEquals(new ArrayList<>(), cartItemTest.getProduct());
            }
        }

        shoppingCartTest.addToCart(1);
        shoppingCartTest.addToCart(1);
        shoppingCartTest.removeFromCart(1);
        for (CartItem cartItemTest : cartItemsTest){
            if(cartItemTest.getProduct().getId() == 1) {
                assertEquals(1, cartItemTest.getAmount());
            }
        }

        assertThrows(ProductNotFoundException.class, ()->
                shoppingCartTest1.removeFromCart(200));
    }
}

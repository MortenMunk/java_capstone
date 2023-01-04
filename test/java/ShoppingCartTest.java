import com.main.*;
import com.main.exceptions.CannotRemoveFromCartWhenAmountZero;
import com.main.exceptions.ProductNotFoundException;
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
    ShoppingCart shoppingCartTest1 = new ShoppingCart();
    ShoppingCart shoppingCartTest2 = new ShoppingCart();
    ArrayList<CartItem> cartItemsTest;
    CartItem cartItemTest;

    @BeforeEach()
    void BeforeEach() {
        Shop shopTest = new Shop();
        Shop shopTest1 = new Shop();
        Shop shopTest2 = new Shop();
        Beverages cola = new Beverages(1 ,"Cola", 15.99);
        shopTest.addProduct(1, cola);
        ArrayList<CartItem> cartItemsTest = new ArrayList<>();
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
        assertEquals(true, shoppingCartTest.IsItemAlreadyInCart(1));
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
}

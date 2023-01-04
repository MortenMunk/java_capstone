import com.main.Beverages;
import com.main.Shop;
import com.main.ShoppingCart;
import com.main.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    ShoppingCart shoppingCartTest = new ShoppingCart();

    // BEVERAGE LIST
    Beverages cola = new Beverages(1 ,"Cola", 15.99);
    ShoppingCart shoppingCartTest1 = new ShoppingCart();

    @Test
    void TestGetCartItems() {
        assertEquals(shoppingCartTest.getCartItems(), shoppingCartTest1.getCartItems());
    }

    @Test
    void TestGetProducts() {
        assertEquals(shoppingCartTest.getProducts(), shoppingCartTest1.getProducts());
    }

}

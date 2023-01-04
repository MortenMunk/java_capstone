import com.main.Product;
import com.main.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    ShoppingCart shoppingCartTest = new ShoppingCart(1, "test", 2, 10);

    @Test
    void TestConstructor() {
        assertEquals(1, shoppingCartTest.getCartID());
        assertEquals("test", shoppingCartTest.getName());
        assertEquals(2, shoppingCartTest.getAmount());
        assertEquals(10, shoppingCartTest.getPrice());
    }

}

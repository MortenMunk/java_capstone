import com.main.Beverages;
import com.main.CartItem;
import com.main.Shop;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopTest {
    Beverages beverageTest = new Beverages(1,"Water", 10);
    CartItem cartItemTest = new CartItem(beverageTest, 2);
    private ArrayList<CartItem> cartItemsTest = new ArrayList<>();
    Shop shopTest = new Shop();

    @Test
    void TestGetItems() {
        assertEquals(new ArrayList<CartItem>(),shopTest.getItems());
    }

    @Test
    void TestAddProduct(){
        Shop shopTest1 = new Shop();
        Shop shopTest2 = new Shop();
        shopTest1.addProduct(1, beverageTest);
        shopTest2.addProduct(1, beverageTest);
        assertEquals(shopTest1.getProducts(), shopTest2.getProducts());
    }

}

import com.main.Beverages;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeveragesTest {
    Beverages beverageTest = new Beverages("Water",2, 10);
    @Test
    void TestBeveragesConstructor() {
        assertEquals("Water", beverageTest.getName());
        assertEquals(2, beverageTest.getStockLeft());
        assertEquals(10, beverageTest.getPrice());
        assertEquals(true, beverageTest.isInStock());
        assertEquals(Category.BEVERAGES, beverageTest.getCategory());
    }

    @Test
    void TestGetterSetterID() {
        beverageTest.setId(1);
        assertEquals(1, beverageTest.getId());
    }
}

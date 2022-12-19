import com.main.Beverages;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeveragesTest {
    @Test
    void TestBeveragesConstructor() {
        Beverages beverageTest = new Beverages(1,"Water", 2, 10, Category.BEVERAGES);
        assertEquals(1, beverageTest.getId());
        assertEquals("Water", beverageTest.getName());
        assertEquals(2, beverageTest.getStockLeft());
        assertEquals(10, beverageTest.getPrice());
        assertEquals(true, beverageTest.isInStock());
        assertEquals(Category.BEVERAGES, beverageTest.getCategory());
    }
}

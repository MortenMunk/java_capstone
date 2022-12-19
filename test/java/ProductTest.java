import com.main.Beverages;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void TestIsInStock() {
        Beverages beverageTest = new Beverages(1,"Water", 2, 10, Category.BEVERAGES);
        assertEquals(true, beverageTest.isInStock());

        Beverages beverageTest1 = new Beverages(2,"Water", 0, 10, Category.BEVERAGES);
        assertEquals(false,beverageTest1.isInStock());
    }

    @Test
    void TestSetStockLeftWithNegativeValue() {
        Beverages beverageTest = new Beverages(1,"Water", 2, 10, Category.BEVERAGES);
        assertThrows(IllegalArgumentException.class, ()->
                beverageTest.setStockLeft(-3));
    }

    @Test
    void TestSetStockLeft() {
        Beverages beverageTest = new Beverages(1,"Water", 2, 10, Category.BEVERAGES);
        beverageTest.setStockLeft(10);
        assertEquals(10, beverageTest.getStockLeft());
    }
}

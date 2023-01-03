import com.main.Beverages;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void TestIsInStock() {
        Beverages beverageTest = new Beverages("Water", 2, 10);
        assertEquals(true, beverageTest.isInStock());

        Beverages beverageTest1 = new Beverages("Water", 0, 10);
        assertEquals(false,beverageTest1.isInStock());
    }

    @Test
    void TestSetStockLeftWithNegativeValue() {
        Beverages beverageTest = new Beverages("Water", 2, 10);
        assertThrows(IllegalArgumentException.class, ()->
                beverageTest.setStockLeft(-3));
    }

    @Test
    void TestSetStockLeft() {
        Beverages beverageTest = new Beverages("Water", 2, 10);
        beverageTest.setStockLeft(10);
        assertEquals(10, beverageTest.getStockLeft());
    }
}

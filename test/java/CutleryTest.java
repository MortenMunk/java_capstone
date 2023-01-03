import com.main.Cutlery;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CutleryTest {
    @Test
    void TestCutleryConstructor() {
        Cutlery cutleryTest = new Cutlery("Plastic spoon", 5, 4);
        assertEquals("Plastic spoon", cutleryTest.getName());
        assertEquals(5, cutleryTest.getStockLeft());
        assertEquals(4, cutleryTest.getPrice());
        assertEquals(true, cutleryTest.isInStock());
        assertEquals(Category.CUTLERY, cutleryTest.getCategory());
    }
}

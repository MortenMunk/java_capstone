import com.main.Cutlery;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CutleryTest {
    Cutlery cutleryTest = new Cutlery("Plastic spoon", 5, 4);
    @Test
    void TestCutleryConstructor() {
        assertEquals("Plastic spoon", cutleryTest.getName());
        assertEquals(5, cutleryTest.getStockLeft());
        assertEquals(4, cutleryTest.getPrice());
        assertEquals(true, cutleryTest.isInStock());
        assertEquals(Category.CUTLERY, cutleryTest.getCategory());
    }

    @Test
    void TestGetterSetterID() {
        cutleryTest.setId(1);
        assertEquals(1, cutleryTest.getId());
    }
}

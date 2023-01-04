import com.main.Edibles;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdiblesTest {
    Edibles edibleTest = new Edibles("Pizza", 2, 18);

    @Test
    void TestEdiblesConstructor() {
        assertEquals("Pizza", edibleTest.getName());
        assertEquals(2, edibleTest.getStockLeft());
        assertEquals(18, edibleTest.getPrice());
        assertEquals(true, edibleTest.isInStock());
        assertEquals(Category.EDIBLES, edibleTest.getCategory());
    }

    @Test
    void TestGetterSetterID() {
        edibleTest.setId(1);
        assertEquals(1, edibleTest.getId());
    }
}

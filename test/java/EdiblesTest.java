import com.main.Edibles;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdiblesTest {
    @Test
    void TestEdiblesConstructor() {
        Edibles edibleTest = new Edibles(1,"Pizza", 2, 18, Category.EDIBLES);
        assertEquals(1, edibleTest.getId());
        assertEquals("Pizza", edibleTest.getName());
        assertEquals(2, edibleTest.getStockLeft());
        assertEquals(18, edibleTest.getPrice());
        assertEquals(true, edibleTest.isInStock());
        assertEquals(Category.EDIBLES, edibleTest.getCategory());
    }
}

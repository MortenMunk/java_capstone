import com.main.Beverages;
import com.main.Cutlery;
import com.main.Edibles;
import com.main.Product;
import com.main.Product.Category;
import com.main.exceptions.StockCannotBeNegativeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    Beverages beverageTest = new Beverages("Water", 2, 10);

    @Test
    void TestIsInStock() {
        assertEquals(true, beverageTest.isInStock());

        Beverages beverageTest1 = new Beverages("Water", 0, 10);
        assertEquals(false,beverageTest1.isInStock());
    }

    @Test
    void TestSetStockLeftWithNegativeValue() {
        assertThrows(StockCannotBeNegativeException.class, ()->
                beverageTest.setStockLeft(-3));
    }

    @Test
    void TestSetStockLeft() {
        beverageTest.setStockLeft(10);
        assertEquals(10, beverageTest.getStockLeft());
    }

    @Test
    void TestRemoveOneStock() {
        beverageTest.removeOneStock();
        assertEquals(1, beverageTest.getStockLeft());
    }

    @Test
    void TestAddOneStock() {
        beverageTest.addOneStock();
        assertEquals(3, beverageTest.getStockLeft());
    }

}

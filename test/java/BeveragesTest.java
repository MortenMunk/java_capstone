//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

import com.main.Beverages;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeveragesTest {
    Beverages beverageTest = new Beverages(1,"Water", 10);
    @Test
    void TestBeveragesConstructor() {
        assertEquals("Water", beverageTest.getName());
        assertEquals(10, beverageTest.getPrice());
        assertEquals(Category.BEVERAGES, beverageTest.getCategory());
    }

    @Test
    void TestGetterSetterID() {
        beverageTest.setId(1);
        assertEquals(1, beverageTest.getId());
    }
}

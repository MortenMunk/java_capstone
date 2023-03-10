//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

import com.main.Cutlery;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CutleryTest {
    Cutlery cutleryTest = new Cutlery(1, "Plastic spoon", 4);
    @Test
    void TestCutleryConstructor() {
        assertEquals("Plastic spoon", cutleryTest.getName());
        assertEquals(4, cutleryTest.getPrice());
        assertEquals(Category.CUTLERY, cutleryTest.getCategory());
    }

    @Test
    void TestGetterSetterID() {
        cutleryTest.setId(1);
        assertEquals(1, cutleryTest.getId());
    }
}

//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

import com.main.Edibles;
import com.main.Product.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdiblesTest {
    Edibles edibleTest = new Edibles(1,"Pizza", 18);

    @Test
    void TestEdiblesConstructor() {
        assertEquals("Pizza", edibleTest.getName());
        assertEquals(18, edibleTest.getPrice());
        assertEquals(Category.EDIBLES, edibleTest.getCategory());
    }

    @Test
    void TestGetterSetterID() {
        edibleTest.setId(1);
        assertEquals(1, edibleTest.getId());
    }
}

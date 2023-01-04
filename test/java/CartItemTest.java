import com.main.*;
import com.main.exceptions.BillingAmountCannotExceedBalanceException;
import com.main.exceptions.CannotRemoveFromCartWhenAmountZero;
import com.main.exceptions.StockCannotBeNegativeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartItemTest {

    Beverages beverageTest = new Beverages(1,"Water", 10);
    CartItem cartItemTest = new CartItem(beverageTest, 2);
    CartItem cartItemTestDupe = new CartItem(beverageTest, 2);

    CartItem cartItemTest1 = new CartItem(beverageTest, 0);

    @Test
    void TestRemoveOneStock() {
        cartItemTest.removeAmount(1);
        assertEquals(1, cartItemTest.getAmount());
    }

    @Test
    void TestAddOneStock() {
        cartItemTest.addAmount(1);
        assertEquals(3, cartItemTest.getAmount());
    }

    @Test
    void TestRemoveFromCartWhenAmountZero() {
        assertThrows(CannotRemoveFromCartWhenAmountZero.class, ()->
                cartItemTest1.removeAmount(1));
    }

    @Test
    void TestGetProducts() {

        assertSame(cartItemTest.getProduct(), cartItemTestDupe.getProduct());
    }
}

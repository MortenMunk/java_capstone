import com.main.User;
import com.main.exceptions.BalanceCannotBeNegativeException;
import com.main.exceptions.BillingAmountCannotExceedBalanceException;
import com.main.exceptions.CannotBillWithNoChargeException;
import com.main.exceptions.DepositCannotBeNegativeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserTest {

    @Test
    void TestUserGetter(){
        User userTest = new User("Test", 1337);
        assertEquals("Test", userTest.getName());
        assertEquals(1337, userTest.getBalance());
    }

    @Test
    void TestUserSetter(){
        User userTest = new User("Test", 1337);
        userTest.setName("New name");
        userTest.setBalance(200);
        assertEquals("New name", userTest.getName());
        assertEquals(200, userTest.getBalance());
        assertThrows(BalanceCannotBeNegativeException.class, () ->
                userTest.setBalance(-10));
    }

    @Test
    void TestUserDeposit() {
        User userTest = new User("Test", 100);
        userTest.deposit(100);
        assertEquals(200, userTest.getBalance());
    }

    @Test
    void TestUserBillAmount() {
        User userTest = new User("Test", 100);
        userTest.billAmount(50);
        assertEquals(50, userTest.getBalance());
    }

    @Test
     void TestUserBillingWithInsufficientFunds() {
        User userTest = new User("Test", 100);
        assertThrows(BillingAmountCannotExceedBalanceException.class, ()->
                userTest.billAmount(130));
    }

    @Test
    void TestUserBillingWithNegativeAmount() {
        User userTest = new User("Test", 100);
        assertThrows(CannotBillWithNoChargeException.class, ()->
                userTest.billAmount(-10));
    }

    @Test
    void TestUserDepositWithNegativeAmount() {
        User userTest = new User("Test", 100);
        assertThrows(DepositCannotBeNegativeException.class, ()->
                userTest.deposit(-10));
    }

    @Test
    void TestUserConstructorOptionalBalance() {
        User userTest = new User("Test");
        assertEquals("Test", userTest.getName());
        assertEquals(0.0, userTest.getBalance());
    }
}

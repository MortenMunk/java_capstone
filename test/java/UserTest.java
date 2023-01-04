//      ###################################
//      ||                               ||
//      ||     Morten Munk Andersen      ||
//      ||    Mortan21@student.aau.dk    ||
//      ||     2022 CAPSTONE PROJECT     ||
//      ||                               ||
//      ###################################

import com.main.User;
import com.main.exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserTest {
    User userTest = new User("Test", 1337);

    @Test
    void TestUserGetter(){
        assertEquals("Test", userTest.getName());
        assertEquals(1337, userTest.getBalance());
    }

    @Test
    void TestUserSetter(){
        userTest.setName("New name");
        userTest.setBalance(200);
        assertEquals("New name", userTest.getName());
        assertEquals(200, userTest.getBalance());
        assertThrows(BalanceCannotBeNegativeException.class, () ->
                userTest.setBalance(-10));
    }

    @Test
    void TestUserDeposit() {
        userTest.deposit(100);
        assertEquals(1437, userTest.getBalance());
    }

    @Test
    void TestUserBillAmount() {
        userTest.billAmount(50);
        assertEquals(1287, userTest.getBalance());
    }

    @Test
     void TestUserBillingWithInsufficientFunds() {
        assertThrows(BillingAmountCannotExceedBalanceException.class, ()->
                userTest.billAmount(1338));
    }

    @Test
    void TestUserBillingWithNegativeAmount() {
        assertThrows(CannotBillWithNoChargeException.class, ()->
                userTest.billAmount(-10));
    }

    @Test
    void TestUserDepositWithNegativeAmount() {
        assertThrows(DepositCannotBeNegativeException.class, ()->
                userTest.deposit(-10));
    }

    @Test
    void TestUserConstructorOptionalBalance() {
        User userTest1 = new User("Test");
        assertEquals("Test", userTest1.getName());
        assertEquals(0.0, userTest1.getBalance());
    }

    @Test
    void TestInvalidActionInputException() {
        assertThrows(InvalidActionInputException.class, ()->
                userTest.invalidInput());
    }
}

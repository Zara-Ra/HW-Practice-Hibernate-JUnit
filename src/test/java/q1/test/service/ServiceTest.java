package q1.test.service;

import ir.maktab.q1.model.entity.*;
import ir.maktab.q1.service.IService;
import ir.maktab.q1.service.impl.ServiceImpl;
import ir.maktab.q1.util.exceptions.ValidationException;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {
    private static final IService service = new ServiceImpl();
    private static final Account[] accounts = new Account[6];

    @BeforeAll
    public static void accountData() {
        LocalDate openingDate = LocalDate.now();
        LocalDate expiryDate = LocalDate.parse("2027-11-11");

        accounts[0] = new ShortTermAccount("1000", "9031989984", openingDate, 30.0, expiryDate, 0.01);
        accounts[1] = new CurrentAccount("1001", "6362141059922787", openingDate, 10.0, expiryDate, "CheckBook1001");
        accounts[2] = new LongTermAccount("1002", "1212131314141515", openingDate, 20.0, expiryDate, 0.2);
        accounts[3] = new NoProfitAccount("1003", "9876987698769876", openingDate, 40.0, expiryDate);
        accounts[4] = new LongTermAccount("1004", "1234123412341234", LocalDate.parse("2017-10-10"), 50.0, expiryDate, 0.2);
        accounts[5] = new ShortTermAccount("1005", "4567456745674567", openingDate, 30.0, expiryDate, 0.01);
        for (int i = 1; i < accounts.length; i++) {
            service.createNewAccount(accounts[i]);
        }
    }

    @Test
    @Order(1)
    public void createInvalidNewAccountTest() {
        ValidationException exception = assertThrows(ValidationException.class, () -> service.createNewAccount(accounts[0]));
        assertEquals("Credit Card number should be 16 digits", exception.getMessage());
    }

    @Test
    @Order(2)
    public void findByIdTest() {
        Account foundAccount = service.findAccountById(5);
        assertTrue(accounts[5].equals(foundAccount));
    }

    @Test
    @Order(3)
    public void deleteTest() {
        service.deleteAccount(5);
        assertNull(service.findAccountById(5));
    }

    @Test
    @Order(4)
    public void withdrawTest() {
        service.withdraw(accounts[1], 5);
        Account withdrawedAccount = service.findAccountById(1);
        assertEquals(5, withdrawedAccount.getCredit());
    }

    @Test
    @Order(5)
    public void negativeWithdrawTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> service.withdraw(accounts[3], -10));
        assertEquals("Sorry, you can not withdraw a negative amount", exception.getMessage());
    }

    @Test
    @Order(6)
    public void extraWithdrawTest() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.withdraw(accounts[3], 50));
        assertEquals("Your balance is not enough", exception.getMessage());
    }

    @Test
    @Order(7)
    public void depositTest() {
        service.deposit(accounts[2], 100);
        Account depositedAccount = service.findAccountById(2);
        assertEquals(120, depositedAccount.getCredit());
    }

    @Test
    @Order(8)
    public void negativeDepositTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> service.withdraw(accounts[1], -10));
        assertEquals("Sorry, you can not withdraw a negative amount", exception.getMessage());

    }
}

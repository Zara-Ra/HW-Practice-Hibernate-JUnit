package q1.test.service;

import ir.maktab.q1.model.entity.Account;
import ir.maktab.q1.model.entity.LongTermAccount;
import ir.maktab.q1.service.IService;
import ir.maktab.q1.service.impl.LongTermAccountServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LongTermServiceTest {
    private static final IService service = new LongTermAccountServiceImpl();
    private static final Account[] accounts = new Account[2];

    @BeforeAll
    public static void accountData() {
        LocalDate openingDate = LocalDate.now();
        LocalDate expiryDate = LocalDate.parse("2027-11-11");
        accounts[0] = new LongTermAccount("1002", "1212131314141515", openingDate, 20.0, expiryDate, 0.2);
        accounts[1] = new LongTermAccount("1004", "1234123412341234", LocalDate.parse("2017-10-10"), 50.0, expiryDate, 0.2);
        service.createNewAccount(accounts[0]);
        service.createNewAccount(accounts[1]);
    }

    @Test
    public void withdrawTest() {
        service.withdraw(accounts[1], 30);
        Account withdrawedAccount = service.findAccountById(2);
        assertEquals(20, withdrawedAccount.getCredit());
    }

    @Test
    public void invalidWithdrawTest() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.withdraw(accounts[0], 10));
        assertEquals("Sorry, you can not withdraw from this long term account yet", exception.getMessage());
    }
}

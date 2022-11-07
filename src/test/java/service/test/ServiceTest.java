package service.test;

import ir.maktab.q1.model.entity.*;
import ir.maktab.q1.service.IService;
import ir.maktab.q1.service.impl.ServiceImpl;
import ir.maktab.q1.util.exceptions.ValidationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTest {
    private IService service = new ServiceImpl();
    private static Account[] accounts = new Account[5];

    @BeforeAll
    public static void accountData() {
        LocalDate openingDate = LocalDate.now();
        LocalDate expiryDate = LocalDate.parse("2027-11-11");

        accounts[0] = new CurrentAccount("1000", "6362141059922787", openingDate, 10.0, expiryDate, "CheckBook1001");
        accounts[1] = new LongTermAccount("1001", "1234123412341234", openingDate, 20.0, expiryDate, 0.2);
        accounts[2] = new ShortTermAccount("1002", "9031989984", openingDate, 30.0, expiryDate, 0.01);
        accounts[3] = new NoProfitAccount("1003", "0985085r0q8w", openingDate, 40.0, expiryDate);
        accounts[4] = new LongTermAccount("1004", "1234123412341234", LocalDate.parse("2017-10-10"), 50.0, expiryDate, 0.2);
    }

    @Test
    public void createNewAccountTest() {
        ValidationException exception = assertThrows(ValidationException.class,()->service.createNewAccount(accounts[2])) ;
        assertEquals("Credit Card number should be 16 digits",exception.getMessage());
    }
}

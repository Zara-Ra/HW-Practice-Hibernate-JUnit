package q1.test.repository;

import ir.maktab.q1.model.entity.*;
import ir.maktab.q1.model.repository.IRepository;
import ir.maktab.q1.model.repository.impl.RepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepoTest {
    private static IRepository repository;
    private static Account[] accounts = new Account[5];

    @BeforeAll
    static void setRepository() {
        repository = new RepositoryImpl();
    }

    public static Account[] accountData() {
        LocalDate openingDate = LocalDate.now();
        LocalDate expiryDate = LocalDate.parse("2027-11-11");

        accounts[0] = new CurrentAccount("1000", "6362141059922787", openingDate, 10.0, expiryDate, "CheckBook1001");
        accounts[1] = new LongTermAccount("1001", "1234123412341234", openingDate, 20.0, expiryDate, 0.2);
        accounts[2] = new ShortTermAccount("1002", "9031989984", openingDate, 30.0, expiryDate, 0.01);
        accounts[3] = new NoProfitAccount("1003", "0985085r0q8w", openingDate, 40.0, expiryDate);
        accounts[4] = new LongTermAccount("1004", "1234123412341234", LocalDate.parse("2017-10-10"), 50.0, expiryDate, 0.2);
        return accounts;
    }

    @ParameterizedTest
    @MethodSource(value = "accountData")
    void testSave(Account account) {
        repository.save(account);
    }

    @Test
    void testFindById() {
        for (int i = 0; i < accounts.length; i++) {
            Account foundAccount = repository.findById(i + 1);
            assertTrue(foundAccount.equals(accounts[i]));
        }
    }

    @Test
    void testFindAll() {
        List all = repository.findAll();
        assertEquals(5, all.size());
    }

    @Test
    void testUpdate() {
        repository.update(1, 1000);
        Account account = repository.findById(1);
        assertEquals(1000, account.getCredit());
    }

    @Test
    void testDelete() {
        repository.delete(2);
        Account delAccount = repository.findById(2);
        assertNull(delAccount);
    }
}

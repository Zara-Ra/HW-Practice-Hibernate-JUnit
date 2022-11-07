package repository.test;

import ir.maktab.q1.model.entity.*;
import ir.maktab.q1.model.repository.IRepository;
import ir.maktab.q1.model.repository.impl.RepositoryImpl;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDate;

public class RepoTest {
    private IRepository repository;
    @BeforeAll
    void setRepository(){
        repository = new RepositoryImpl();
    }

    public static Account[] accountData(){
        LocalDate openingDate = LocalDate.now();
        LocalDate expiryDate = LocalDate.parse("2027-11-11");
        Account[] accounts = new Account[5];
        accounts[0] = new CurrentAccount("1001","6362141059922787", openingDate,10.0,openingDate,"CheckBook1001");
        accounts[1] = new LongTermAccount("1002","1234123412341234",openingDate,20.0,expiryDate,0.2);
        accounts[2] = new ShortTermAccount("1003","9031989984", openingDate,30.0,expiryDate,0.01);
        accounts[3] = new NoProfitAccount("1004","0985085r0q8w",openingDate,40.0,expiryDate);
        accounts[4] = new LongTermAccount("1005","1234123412341234",openingDate,50.0,expiryDate,0.2);


        return accounts;
    }
}

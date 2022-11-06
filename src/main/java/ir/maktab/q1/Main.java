package ir.maktab.q1;

import ir.maktab.q1.model.entity.*;
import ir.maktab.q1.model.repository.IRepository;
import ir.maktab.q1.model.repository.impl.RepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IRepository repo = new RepositoryImpl<>();
        LocalDate openingDate = LocalDate.now();
        CurrentAccount account = new CurrentAccount("1001","6362141059922787",
                openingDate,1000,1234,openingDate,"CheckBook1001");
        repo.save(account);
        repo.update(1,2000);
        account.setAccountNumber("1002");
        repo.save(account);
        CurrentAccount foundAccount = (CurrentAccount) repo.findById(1);
        System.out.println(foundAccount);
        //currentAccountIRepository.delete(3);

        LongTermAccount account1 = new LongTermAccount("1003","1234123412341234",openingDate,1500,456,openingDate,0.2);
        repo.save(account1);

        ShortTermAccount account2 = new ShortTermAccount("1004","9031989984",LocalDate.parse("2020-11-11"),1200,345,openingDate,0.01);
        repo.save(account2);

        NoProfitAccount account3 = new NoProfitAccount("1005","0985085r0q8w",openingDate,3,3993,openingDate);
        repo.save(account3);

        List allAccounts = repo.findAll();
        System.out.println(allAccounts.size());
    }
}

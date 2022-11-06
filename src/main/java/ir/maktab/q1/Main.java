package ir.maktab.q1;

import ir.maktab.q1.model.entity.Account;
import ir.maktab.q1.model.entity.CurrentAccount;
import ir.maktab.q1.model.entity.LongTermAccount;
import ir.maktab.q1.model.repository.IRepository;
import ir.maktab.q1.model.repository.impl.RepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDate openingDate = LocalDate.parse("2022-08-12");
        LocalDate today = LocalDate.now();

        int diff = LocalDate.now().compareTo(openingDate);
        int timeInAccount = diff/365;
        System.out.println(today + " "+openingDate+ " "+diff);
        System.out.println(timeInAccount);
        /*IRepository currentAccountIRepository = new RepositoryImpl<>();
        LocalDate openingDate = LocalDate.now();
        CurrentAccount account = new CurrentAccount("1234","6362141059922787",
                openingDate,1000,1234,openingDate,"CheckBook1234");
        currentAccountIRepository.save(account);
        currentAccountIRepository.update(1,2000);
        account.setAccountNumber("9876");
        currentAccountIRepository.save(account);
        CurrentAccount foundAccount = (CurrentAccount) currentAccountIRepository.findById(1);
        System.out.println(foundAccount);
        //currentAccountIRepository.delete(3);

        IRepository longTermAccountIRepository = new RepositoryImpl<>();
        LongTermAccount account1 = new LongTermAccount("1234","1234123412341234",openingDate,1500,456,openingDate,0.2);
        longTermAccountIRepository.save(account1);

        List allAccounts = currentAccountIRepository.findAll();
        System.out.println(allAccounts.size());*/
    }
}

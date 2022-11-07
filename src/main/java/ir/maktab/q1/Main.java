package ir.maktab.q1;

import ir.maktab.q1.model.entity.*;
import ir.maktab.q1.model.repository.IRepository;
import ir.maktab.q1.model.repository.impl.RepositoryImpl;
import ir.maktab.q1.service.IService;
import ir.maktab.q1.service.impl.LongTermAccountServiceImpl;
import ir.maktab.q1.service.impl.ServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //IRepository repo = new RepositoryImpl<>();
        IService service = new ServiceImpl<>();
        IService serviceLongTerm = new LongTermAccountServiceImpl();
        LocalDate openingDate = LocalDate.now();
        /*CurrentAccount account = new CurrentAccount("1001","6362141059922787",
                openingDate,1000,1234,openingDate,"CheckBook1001");

        service.createNewAccount(account);

        account.setAccountNumber("1002");
        service.createNewAccount(account);

        LongTermAccount account1 = new LongTermAccount("1003","1234123412341234",openingDate,1500,456,openingDate,0.2);
        serviceLongTerm.createNewAccount(account1);

        ShortTermAccount account2 = new ShortTermAccount("1004","9031989984",LocalDate.parse("2020-11-11"),1200,345,openingDate,0.01);
        service.createNewAccount(account2);

        NoProfitAccount account3 = new NoProfitAccount("1005","0985085r0q8w",openingDate,3,3993,openingDate);
        service.createNewAccount(account3);

        service.deleteAccount(1);
        List allAccounts = service.displayAllAccounts();
        System.out.println(allAccounts.size());

        serviceLongTerm.deposit(account1,10000000);
        service.deposit(account2,200000000);

        service.withdraw(account3,1);
        serviceLongTerm.withdraw(account1,1);
*/
    }
}

package ir.maktab.q1;

import ir.maktab.q1.model.entity.Account;
import ir.maktab.q1.model.entity.CurrentAccount;
import ir.maktab.q1.model.repository.IRepository;
import ir.maktab.q1.model.repository.impl.RepositoryImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        IRepository<CurrentAccount> currentAccountIRepository = new RepositoryImpl<>();
        LocalDate openingDate = LocalDate.now();
        CurrentAccount account = new CurrentAccount("1234","6362141059922787",
                openingDate,1000,1234,openingDate,"CheckBook1234");
        currentAccountIRepository.save(account);
        currentAccountIRepository.update(1,5000);

        CurrentAccount foundAccount = currentAccountIRepository.findById(1);
        System.out.println(foundAccount);
    }
}

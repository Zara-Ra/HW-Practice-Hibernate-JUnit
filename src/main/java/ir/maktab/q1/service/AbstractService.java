package ir.maktab.q1.service;

import ir.maktab.q1.model.entity.Account;
import ir.maktab.q1.model.entity.CurrentAccount;
import ir.maktab.q1.model.repository.IRepository;
import ir.maktab.q1.model.repository.impl.RepositoryImpl;
import ir.maktab.q1.service.IService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class AbstractService<T extends Account> implements IService<T> {
    IRepository<T> repository = new RepositoryImpl<>();

    @Override
    public void createNewAccount(T account) {
        //todo validations
        repository.save(account);
    }
    @Override
    public void deleteAccount(int id) {
        repository.delete(id);
    }

    @Override
    public T findAccountById(int id) {
        return repository.findById(id);
    }

    @Override
    public List displayAllAccounts() {
        return repository.findAll();
    }

    @Override
    public void deposit(T account, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not deposit a negative amount");
        }
        account.setCredit(account.getCredit() + amount);
        repository.update(account.getId(), account.getCredit());
    }
}

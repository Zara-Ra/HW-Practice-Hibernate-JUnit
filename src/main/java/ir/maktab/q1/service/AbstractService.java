package ir.maktab.q1.service;

import ir.maktab.q1.model.entity.Account;
import ir.maktab.q1.service.IService;

import java.util.List;

public abstract class AbstractService<T extends Account> implements IService<T> {

    @Override
    public void deleteAccount(T account) {

    }

    @Override
    public T findAccountById(int id) {
        return null;
    }

    @Override
    public List displayAllAccounts() {
        return null;
    }

    @Override
    public void deposit(T account) {

    }
}

package ir.maktab.q1.service;

import ir.maktab.q1.model.entity.Account;
import ir.maktab.q1.util.exceptions.ValidationException;

import java.util.List;

public interface IService<T extends Account> {
    void createNewAccount(T account) throws ValidationException;
    void deleteAccount(int id);
    T findAccountById(int id);
    List<T> displayAllAccounts();
    void withdraw(T account,double amount);
    void deposit(T account,double amount);
}

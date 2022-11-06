package ir.maktab.q1.service;

import ir.maktab.q1.model.entity.Account;

import java.util.List;

public interface IService<T extends Account> {
    void createNewAccount(T account);
    void deleteAccount(int id);
    T findAccountById(int id);
    List<T> displayAllAccounts();
    void withdraw(T account,double amount);
    void deposit(T account,double amount);
}

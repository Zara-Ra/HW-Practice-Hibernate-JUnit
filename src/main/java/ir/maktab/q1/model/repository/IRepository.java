package ir.maktab.q1.model.repository;

import ir.maktab.q1.model.entity.Account;

public interface IRepository<T extends Account> {
    void save(T account);
    T findById(int id);
    void update(int id, double credit);
    void delete(int id);
}

package ir.maktab.q1.model.repository;

import ir.maktab.q1.model.entity.Account;

import java.util.List;

public interface IRepository<T extends Account> {
    void save(T account);

    T findById(int id);

    List<T> findAll();

    void update(int id, double credit);

    void delete(int id);
}

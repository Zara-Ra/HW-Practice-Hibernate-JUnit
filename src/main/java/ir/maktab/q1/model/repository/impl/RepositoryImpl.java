package ir.maktab.q1.model.repository.impl;

import ir.maktab.q1.model.entity.Account;
import ir.maktab.q1.model.repository.DBConfig;
import ir.maktab.q1.model.repository.IRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class RepositoryImpl<T extends Account> implements IRepository<T> {
    public static SessionFactory sessionFactory = DBConfig.getInstance().getSessionFactory();

    @Override
    public void save(T account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    @Override
    public T findById(int id) {
        Session session = sessionFactory.openSession();
        T account = (T) session.get(Account.class,id);
        session.close();
        return account;
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        List allAccounts = session.createQuery("From Account ").list();
        session.close();
        return allAccounts;
    }

    @Override
    public void update(int id, double credit) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T account = (T) session.get(Account.class,id);
        account.setCredit(credit);
        session.update(account);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T account = (T) session.get(Account.class,id);
        session.delete(account);
        transaction.commit();
        session.close();
    }
}

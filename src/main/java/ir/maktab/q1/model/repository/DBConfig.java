package ir.maktab.q1.model.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConfig {
    private static final DBConfig instance = new DBConfig();

    private DBConfig() {
    }

    public static DBConfig getInstance() {
        return instance;
    }

    public SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        return configuration.buildSessionFactory();
    }
}

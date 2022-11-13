package ir.maktab.q1.model.repository;

import ir.maktab.q1.model.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

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
        //This comment is to demonstrate how to Configure Hibernate without xml file
       /* Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/HW14");
        prop.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hbm2ddl.auto", "create");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "zara12");
        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("show_sql", "true"); //If you wish to see the generated sql query

        SessionFactory sessionFactory = new Configuration().addProperties(prop)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(CurrentAccount.class)
                .addAnnotatedClass(LongTermAccount.class)
                .addAnnotatedClass(ShortTermAccount.class)
                .addAnnotatedClass(NoProfitAccount.class)
                .buildSessionFactory();
        return sessionFactory;*/
    }
}

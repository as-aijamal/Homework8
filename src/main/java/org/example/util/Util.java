package org.example.util;

import org.example.model.People;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.Environment.*;

public class Util {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSession() {

            Configuration configuration = new Configuration();
            configuration.setProperty(DRIVER, "org.postgresql.Driver");
            configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/postgres");
            configuration.setProperty(USER, "postgres");
            configuration.setProperty(PASS, "postgres");
            configuration.setProperty(HBM2DDL_AUTO, "update");
            configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
            configuration.setProperty(SHOW_SQL, "true");
            configuration.addAnnotatedClass(People.class);
            sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        }

        public static void exit() {
            sessionFactory.close();
        }
}

package com.rupesh.hibernate.util;

import com.rupesh.hibernate.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            final Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            configuration.addAnnotatedClass(User.class);

            return sessionFactory;
        }
        return sessionFactory;
    }
}

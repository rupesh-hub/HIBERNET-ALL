package com.rupesh.hibernate;

import com.rupesh.hibernate.entities.User;
import org.hibernate.Session;

import static com.rupesh.hibernate.util.HibernateUtil.getSessionFactory;

public class Main {

    public static void main(String[] args) {

        final Session session = getSessionFactory().openSession();
        final User user = new User("Rupesh Dulal", "dulal.rupesh965@gmail.com");

        saveUser(session, user);
        getUser(session, 1L);
        updateUser(session, user);
        deleteUser(session, 1L);

        session.close();
    }

    private static void saveUser(final Session session, final User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    private static void getUser(final Session session, final Long userId) {
        System.out.println(session.get(User.class, userId));
    }

    private static void updateUser(final Session session, final User user) {
        final User dbUser = session.get(User.class, user.getId());
        dbUser.setFullName(user.getFullName());
        dbUser.setEmail(user.getEmail());
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    private static void deleteUser(final Session session, final Long userId) {
        final User user = session.get(User.class, userId);
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }


}

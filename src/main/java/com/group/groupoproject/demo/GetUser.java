package com.group.groupoproject.demo;

import com.group.groupoproject.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            int userId = 1;

            User myUser = session.get(User.class, userId);

            System.out.println("Get complete: " + myUser);
            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}

package com.group.groupoproject.demo;

import com.group.groupoproject.models.Role;
import com.group.groupoproject.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUser {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating new user object...");
            User tempUser = new User("John Doe", "test12", "CEO", Role.ADMIN);

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the user...");
            session.save(tempUser);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }

        finally {
            factory.close();
        }
    }
}

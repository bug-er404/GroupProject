package com.group.groupoproject.demo;

import com.group.groupoproject.models.Role;
import com.group.groupoproject.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateUser {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int userId = 1;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting user with id: " + userId);

            User myUser = session.get(User.class, userId);

            System.out.println("Updating user...");
            myUser.setPassword("newTest123");
            myUser.setRole(Role.USER);
            myUser.setTitle("New Head");

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}

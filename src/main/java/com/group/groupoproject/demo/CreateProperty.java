package com.group.groupoproject.demo;

import com.group.groupoproject.models.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateProperty {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Property.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating new property...");

            session.beginTransaction();
            Property tempProperty = new Property();
            // save the project object
            System.out.println("Saving the property...");
            session.save(tempProperty);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }

        finally {
            factory.close();
        }
    }
}

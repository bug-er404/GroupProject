package com.group.groupoproject.demo;

import com.group.groupoproject.models.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateProperty {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Property.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int propertyId = 1;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting property with id: " + propertyId);

            Property myProperty = session.get(Property.class, propertyId);

            System.out.println("Updating property...");
            // Updates - need setters
            // myProperty.

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}

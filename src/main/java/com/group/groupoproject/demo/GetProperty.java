package com.group.groupoproject.demo;

import com.group.groupoproject.models.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetProperty {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Property.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int propertyId = 1;

            Property myProperty = session.get(Property.class, propertyId);

            System.out.println("Get complete: " + myProperty);
            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}

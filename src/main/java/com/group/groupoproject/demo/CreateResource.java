package com.group.groupoproject.demo;

import com.group.groupoproject.models.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateResource {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Resource.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating new Resource object...");
            Resource tempResource = new Resource("XML data files");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the Resource...");
            session.save(tempResource);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }

        finally {
            factory.close();
        }
    }
}

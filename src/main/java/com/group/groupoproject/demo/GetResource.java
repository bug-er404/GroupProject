package com.group.groupoproject.demo;

import com.group.groupoproject.models.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetResource {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Resource.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            int ResourceId = 1;

            Resource myResource = session.get(Resource.class, ResourceId);

            System.out.println("Get complete: " + myResource);
            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}

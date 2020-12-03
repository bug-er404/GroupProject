package com.group.groupoproject.demo;

import com.group.groupoproject.models.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetProject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            int projectId = 1;

            Project myProject = session.get(Project.class, projectId);

            System.out.println("Get complete: " + myProject);
            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}

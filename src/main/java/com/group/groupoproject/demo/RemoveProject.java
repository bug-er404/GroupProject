package com.group.groupoproject.demo;

import com.group.groupoproject.models.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RemoveProject {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int projectId = 1;
            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve user based on the id: primary key
            System.out.println("\nGetting project with id: " + projectId);

            Project myProject = session.get(Project.class, projectId);

            // delete the student
            System.out.println("Deleting user: " + myProject);
            session.delete(myProject);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}

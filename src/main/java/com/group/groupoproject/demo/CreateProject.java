package com.group.groupoproject.demo;

import com.group.groupoproject.models.Project;
import com.group.groupoproject.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateProject {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating new project...");
            // Get user by id
            int userId = 1;
            session.beginTransaction();
            User myUser = session.get(User.class, userId);
            Project tempProject = new Project(myUser);

            // save the project object
            System.out.println("Saving the project...");
            session.save(tempProject);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }

        finally {
            factory.close();
        }
    }
}

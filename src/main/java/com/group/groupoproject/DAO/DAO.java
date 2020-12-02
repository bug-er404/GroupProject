package com.group.groupoproject.DAO;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.group.groupoproject.models.Project;
import com.group.groupoproject.models.Property;
import com.group.groupoproject.models.Resource;
import com.group.groupoproject.models.ResourceDetail;
import com.group.groupoproject.models.User;

public class DAO {
	private static SessionFactory factory;

	public void MysqlConnection() {

	}
	public static void main(String[] args) {
		DAO d = new DAO();
		d.checkFactory();
	}
	public void checkFactory() {
		if (factory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost/resource_management");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Property.class).addAnnotatedClass(User.class)
						.addAnnotatedClass(Project.class).addAnnotatedClass(Resource.class)
						.addAnnotatedClass(ResourceDetail.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				factory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

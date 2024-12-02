package org.zorba.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.zorba.entity.Student;
import org.zorba.entity.Teacher;


public class DatabaseConnectivity {
    public static SessionFactory createSession() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Teacher.class);
        System.out.println("Connection Established");

        return sessionFactory;
    }
}

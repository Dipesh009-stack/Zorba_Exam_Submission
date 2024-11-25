package executionXML;


import Hibernate.Student;
import Hibernate.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InsertData {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        System.out.println("Connection Established");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st Subject ");
        String firstSubject = sc.next();

        System.out.println("Enter 2nd Subject:");
        String secondSubject = sc.next();

        System.out.println("Enter 3ed SUbject");
        String thirdSubject = sc.next();

        System.out.println("Enter 4th Subject");
        String fourthSubject = sc.next();


        Session session = sessionFactory.openSession();
        Transaction tx = null;

//        Subject subject = new Subject();
//        subject.setSubjectName(firstSubject);
//
//        Subject subject1 = new Subject();
//        subject1.setSubjectName(secondSubject);
//
//        Subject subject2 = new Subject();
//        subject2.setSubjectName(thirdSubject);
//
//        Subject subject3 = new Subject();
//        subject3.setSubjectName(fourthSubject);

        try{
            tx = session.beginTransaction();
//            session.persist(subject);
//            session.persist(subject1);
//            session.persist(subject2);
//            session.persist(subject3);
            tx.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Student student = new Student();
        student.setStudnetName("Dipesh");

        Subject subject = new Subject();
        subject.setSubjectName("Physics");

        session.persist(student);
        session.persist(subject);



    }
}

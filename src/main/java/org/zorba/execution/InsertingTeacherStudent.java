package org.zorba.execution;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.zorba.entity.Teacher;
import org.zorba.utility.DatabaseConnectivity;
import org.zorba.utility.ReadTeacherExcelFile;

import java.util.List;

public class InsertingTeacherStudent {
    public static void main(String[] args) {
        SessionFactory sessionFactory = DatabaseConnectivity.createSession();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Teacher> listTeacher = ReadTeacherExcelFile.readTeacher();


        try{
            tx = session.beginTransaction();
            for(Teacher te : listTeacher){
                session.persist(te);
            }
            tx.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());;
        }
    }
}

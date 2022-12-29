package org.example.hibernte.demo;

import org.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

public class CreateStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //create student object
            System.out.println("Creating new Student object.");
            Student student =
                    new Student("Dominik",
                            "Tworek",
                            "dtworek@gmail.com");

            //start transaction
            System.out.println("Starting a transaction.");
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the object.");
            session.save(student);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done.");

        } catch (Exception e) {
            factory.close();
            e.printStackTrace();
        } finally {
            factory.close();
        }


    }

}

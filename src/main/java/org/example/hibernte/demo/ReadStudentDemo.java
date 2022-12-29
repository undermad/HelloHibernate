package org.example.hibernte.demo;

import org.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //create student
            Student tempStudent1 = new Student("Jaroslaw",
                    "Aleksander",
                    "jarAl@gmail.com");
            System.out.println(tempStudent1);

            //save student
            session.beginTransaction();
            session.save(tempStudent1);

            System.out.println("Saved student. Generated id: " + tempStudent1.getId());
            session.getTransaction().commit();

            // start new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrive object from database using id
            System.out.println("\nGetting student with id: " + tempStudent1.getId());

            Student myStudent = session.get(Student.class, tempStudent1.getId());

            System.out.println("Get complete, here is your student: \n" + myStudent);


        } finally {
            factory.close();
        }

    }

}

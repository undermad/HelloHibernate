package org.example.hibernte.demo;

import org.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student1 = new Student("Grzegorz",
                    "Brzeczyszczykiewicz",
                    "grzegorzBrzeczyszczykiewicz@gmail.com");
            Student student2 = new Student("Szymon",
                    "Nazwisko",
                    "szymNaz@gmail.com");
            Student student3 = new Student("Krzysztof",
                    "Kowalski",
                    "kowalskiKrzysztof@gmail.com");

            session.beginTransaction();

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}

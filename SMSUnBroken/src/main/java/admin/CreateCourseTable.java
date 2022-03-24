package admin;

import jpa.entitymodels.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateCourseTable {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Course course = new Course(1, "English", "Anderea Scamaden");
        Course course1 = new Course(2, "Mathematics", "Eustace Niemetz");
        Course course2 = new Course(3, "Anatomy", "Reynolds Pastor");
        Course course3 = new Course(4, "Organic Chemistry", "Odessa Belcher");
        Course course4 = new Course(5, "Physics", "Dani Swallow");
        Course course5 = new Course(6, "Digital Logic", "Glenden Reilingen");
        Course course6 = new Course(7, "Object Oriented Programming", "Giselle Ardy");
        Course course7 = new Course(8, "Data Structures", "Carolan Stoller");
        Course course8 = new Course(9, "Politics", "Carmita De Maine");
        Course course9 = new Course(10, "Art", "Kingsly Doxsey");

        session.save(course);
        session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(course4);
        session.save(course5);
        session.save(course6);
        session.save(course7);
        session.save(course8);
        session.save(course9);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }

}

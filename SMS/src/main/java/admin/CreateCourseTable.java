package admin;

import jpa.entitymodels.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateCourseTable {
    public CreateCourseTable(Session session) {
        //Populate Course Table
        addCourse(session, 1, "English", "Anderea Scamaden");
        addCourse(session, 2, "Mathematics", "Eustace Niemetz");
        addCourse(session, 3, "Anatomy", "Reynolds Pastor");
        addCourse(session, 4, "Organic Chemistry", "Odessa Belcher");
        addCourse(session, 5, "Physics", "Dani Swallow");
        addCourse(session, 6, "Digital Logic", "Glenden Reilingen");
        addCourse(session, 7, "Object Oriented Programming", "Giselle Ardy");
        addCourse(session, 8, "Data Structures", "Carolan Stoller");
        addCourse(session, 9, "Politics", "Carmita De Maine");
        addCourse(session, 10, "Art", "Kingsly Doxsey");
    }
    private void addCourse(Session session, int cId, String cName, String cInstructorName) {
        Course course = new Course(cId, cName, cInstructorName);
        session.save(course);
    }
}

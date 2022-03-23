package jpa;

import jpa.DAO.StudentDAO;
import jpa.Service.StudentService;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SMSStudentServiceTest {
    private Session session;
    private Transaction transaction;
    private SessionFactory factory;

    @BeforeEach
    void setUp(){
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();


        //Drops the Student_Course as it is a table referenceed in a foreign key constraint
        //Truncates the Student and Course Tables
        session.createSQLQuery("DROP TABLE Student_Course;").executeUpdate();
        session.createSQLQuery("TRUNCATE TABLE Student;").executeUpdate();
        session.createSQLQuery("TRUNCATE TABLE Course;").executeUpdate();

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

        //Populate Student Table
        addStudent(session, "hluckham0@google.ru", "Hazel Luckham", "X1uZcoIh0dj");
        addStudent(session, "sbowden1@yellowbook.com", "Sonnnie Bowden", "SJc4aWSU");
        addStudent(session, "qllorens2@howstuffworks.com", "Quillan Llorens", "W6rJuxd");
        addStudent(session, "cstartin3@flickr.com", "Clem Startin", "XYHzJ1S");
        addStudent(session, "tattwool4@biglobe.ne.jp", "Thornie Attwool", "Hjt0SoVmuBz");
        addStudent(session, "hguerre5@deviantart.com", "Harcourt Guerre", "OzcxzD1PGs");
        addStudent(session, "htaffley6@columbia.edu", "Holmes Taffley", "xowtOQ");
        addStudent(session, "aiannitti7@is.gd", "Alexandra Iannitti", "TWP4hf5j");
        addStudent(session, "ljiroudek8@sitemeter.com", "Laryssa Jiroudek", "bXRoLUP");
        addStudent(session, "cjaulme9@bing.com", "Cahra Jaulme", "FnVklVgC6r6");

        transaction.commit();
        session.close();
        factory.close();
    }

    private void addCourse(Session session, int cId, String cName, String cInstructorName) {
        Course course = new Course(cId, cName, cInstructorName);
        session.save(course);
    }
    private void addStudent(Session session, String email, String name, String password) {
        Student student = new Student(email, name, password, new ArrayList<>());
        session.save(student);
    }

    @Test
    public void ManyToMany_IntegrationTest_given_session_after_Initialized_returns_ManyToManyData(){
        StudentDAO studentService = new StudentService();
        @SuppressWarnings("unchecked")
        List<Student> studentList = studentService.getAllStudents();
        Assertions.assertThat(studentList).isNotNull();
        Assertions.assertThat(studentList.size()).isEqualTo(10);

        for(Student student : studentList) {
            Assertions.assertThat(student.getsCourses()).isNotNull();
            Assertions.assertThat(student.getsCourses().size()).isEqualTo(0);
        }
    }

    @Test
    public void ManyToMany_IntegrationTest_given_session_when_Read_returns_ManyToManyData(){
        StudentDAO studentService = new StudentService();
        @SuppressWarnings("unchecked")
        List<Student> studentList = studentService.getAllStudents();
        Assertions.assertThat(studentList).isNotNull();
        Assertions.assertThat(studentList.size()).isEqualTo(10);

        for(Student student : studentList) {
            Assertions.assertThat(student.getsCourses()).isNotNull();
            Assertions.assertThat(student.getsCourses().size()).isEqualTo(2);
        }
    }
}

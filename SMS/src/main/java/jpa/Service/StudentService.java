package jpa.Service;

import jpa.DAO.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;


public class StudentService implements StudentDAO {
    private SessionFactory factory;
    private Session session;
    private TypedQuery query;
    String hql;

    @Override
    public List<Student> getAllStudents() {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
//------Hibernate Named Query -----------------
        hql = "FROM Student";
        query = session.createQuery(hql);
        List<Student> result = query.getResultList();
        session.close();
        factory.close();
        return result;
    }

    @Override
    public Student getStudentByEmail(String sEmail) {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
//------Hibernate Named Query -----------------
        hql = "FROM Student WHERE sEmail = :email";
        query = session.createQuery(hql);
        query.setParameter("email", sEmail);
        Student result = (Student) query.getSingleResult();

        session.close();
        factory.close();
        return result;
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        hql = "FROM Student WHERE sEmail = :email";
        query = session.createQuery(hql);
        query.setParameter("email", sEmail);
        Student student = (Student) query.getSingleResult();
        session.close();
        factory.close();
        if(student.getsPass().equals(sPassword)){
            return true;
        }
        return false;
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        Transaction t = session.beginTransaction();
        Student student = getStudentByEmail(sEmail);
        List<Course> studentCourses= getStudentCourses(sEmail);
        boolean isRegistered = false;
        for(Course c : studentCourses ){
            if(c.getcId() == cId){
                isRegistered = true;
                break;
            }
        }
        if(!isRegistered){
            hql = "FROM Course WHERE cId = :id";
            query = session.createQuery(hql);
            query.setParameter("id", cId);
            studentCourses.add((Course) query.getSingleResult());
            student.setsCourses(studentCourses);
            session.merge(sEmail, student);
            t.commit();
        }
        factory.close();
        session.close();
    }


    @Override
    public List<Course> getStudentCourses(String sEmail) {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        hql = "FROM Student WHERE sEmail = :email ";
        query = session.createQuery(hql);
        query.setParameter("email" , sEmail);
        Student student = (Student) query.getSingleResult();
        return student.getsCourses();
    }
}

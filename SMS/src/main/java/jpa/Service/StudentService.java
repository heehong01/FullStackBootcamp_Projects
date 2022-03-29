package jpa.Service;

import jpa.DAO.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentService implements StudentDAO {
    private SessionFactory factory;
    private Session session;
    private TypedQuery query;
    private String hql;

    @Override
    public List<Student> getAllStudents() {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        hql = "FROM Student";
        try{
            query = session.createQuery(hql);
            List<Student> result = query.getResultList();
            return result;
        }catch (HibernateException e){
            return null;
        }finally{
            session.close();
            factory.close();
        }
    }

    @Override
    public Student getStudentByEmail(String sEmail) {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        hql = "FROM Student WHERE email = :email";
        try{
            query = session.createQuery(hql);
            query.setParameter("email", sEmail);
            Student result = (Student) query.getSingleResult();
            return result;
        }
        catch (NoResultException e){
            return null;
        }catch (HibernateException e){
            return null;
        }finally{
            session.close();
            factory.close();
        }
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        Student student = getStudentByEmail(sEmail);
        if(student != null && student.getsPass().contains(sPassword)){
            return true;
        }
        return false;
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        Student student = getStudentByEmail(sEmail);
        List<Course> studentCourses= getStudentCourses(sEmail);
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        hql = "FROM Course WHERE id = :id";

        try {
            query = session.createQuery(hql);
            query.setParameter("id", cId);
            studentCourses.add((Course) query.getSingleResult());
            student.setsCourses(studentCourses);
            session.update(sEmail, student);
            transaction.commit();
        }catch(HibernateException e){
            System.out.println("You have already registered for this course!");
        }
        finally{
            session.close();
            factory.close();
        }
    }


    @Override
    public List<Course> getStudentCourses(String sEmail) {
        Student student = getStudentByEmail(sEmail);
        return student.getsCourses();
    }
}

package jpa.Service;

import jpa.DAO.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


public class StudentService implements StudentDAO {
    private SessionFactory factory;
    private Session session;
    private TypedQuery query;
    private String hql;

    @Override
    public List<Student> getAllStudents() {
        try{
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();

            hql = "FROM Student";
            query = session.createQuery(hql);
            List<Student> result = query.getResultList();
            return result;
        }catch (HibernateException e){
            e.printStackTrace();
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

        query = session.createQuery(hql);
        query.setParameter("email", sEmail);

        try{
            Student result = (Student) query.getSingleResult();
            return result;
        }
        catch (NoResultException e){
            return null;
        }finally{
            session.close();
            factory.close();
        }
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        Student student = getStudentByEmail(sEmail);
        if(student == null){
            return false;
        }
        if(student.getsPass().contains(sPassword)){
            return true;
        }
        return false;

    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        Student student = getStudentByEmail(sEmail);
        List<Course> studentCourses= getStudentCourses(sEmail);
        boolean isRegistered = false;
        for(Course c : studentCourses ){
            if(c.getcId() == cId){ //use .contains
                isRegistered = true;
                System.out.println("You have already registered for this course!");
                break;
            }
        }
        if(!isRegistered) {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            Transaction t = session.beginTransaction();
            hql = "FROM Course WHERE id = :id";
            query = session.createQuery(hql);
            query.setParameter("id", cId);
            studentCourses.add((Course) query.getSingleResult());
            student.setsCourses(studentCourses);
            session.merge(sEmail, student);
            t.commit();
            factory.close();
            session.close();
        }
    }


    @Override
    public List<Course> getStudentCourses(String sEmail) {
        Student student = getStudentByEmail(sEmail);
        return student.getsCourses();
    }
}

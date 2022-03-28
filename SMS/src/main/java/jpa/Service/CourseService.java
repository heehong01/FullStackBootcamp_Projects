package jpa.Service;

import jpa.DAO.CourseDAO;
import jpa.entitymodels.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;


public class CourseService implements CourseDAO {

    @Override
    public List<Course> getAllCourses() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        try (factory; Session session = factory.openSession()) {
            String hql = "FROM Course";
            TypedQuery query = session.createQuery(hql);
            List<Course> results = query.getResultList();
            return results;
        } catch (HibernateException e) {
            return null;
        }

    }

}

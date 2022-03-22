package admin;

import jpa.entitymodels.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javax.persistence.TypedQuery;
import java.util.List;

public class CheckER {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Student WHERE email=:email";
        TypedQuery query = session.createQuery(hql);
        List<Student> results = query.getResultList();
        for(Student s: results){
            System.out.println("User Id: " + s.getsEmail()+ "|"
                    + " C name: " + s.getsName() +" | "
                    + " I NAME: " + s.getsPass() +" | ");
        }
        factory.close();
        session.close();
    }
}

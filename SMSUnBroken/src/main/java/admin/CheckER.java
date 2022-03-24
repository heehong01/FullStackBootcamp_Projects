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

        String hql = "FROM Course";
        TypedQuery query = session.createQuery(hql);
        query.setParameter("email", "he");
        Student results = (Student) query.getSingleResult();

            System.out.println("User Id: " + results.getsEmail()+ "|"
                    + " C name: " + results.getsName() +" | "
                    + " I NAME: " + results.getsPass() +" | ");

        factory.close();
        session.close();
    }
}

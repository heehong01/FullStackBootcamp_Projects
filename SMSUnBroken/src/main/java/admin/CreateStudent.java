package admin;

import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        /*Student student = new Student("hluckham0@google.ru", "Hazel Luckham", "X1uZcoIh0dj");
        Student student1 = new Student("sbowden1@yellowbook.com", "Sonnnie Bowden", "SJc4aWSU");
        Student student2 = new Student("qllorens2@howstuffworks.com", "Quillan Llorens", "W6rJuxd");
        Student student3 = new Student("cstartin3@flickr.com", "Clem Startin", "XYHzJ1S");
        Student student4 = new Student("tattwool4@biglobe.ne.jp", "Thornie Attwool", "Hjt0SoVmuBz");
        Student student5 = new Student("hguerre5@deviantart.com", "Harcourt Guerre", "OzcxzD1PGs");
        Student student6 = new Student("htaffley6@columbia.edu", "Holmes Taffley", "xowtOQ");
        Student student7 = new Student("aiannitti7@is.gd", "Alexandra Iannitti", "TWP4hf5j");
        Student student8 = new Student("ljiroudek8@sitemeter.com", "Laryssa Jiroudek", "bXRoLUP");
        Student student9 = new Student("cjaulme9@bing.com", "Cahra Jaulme", "FnVklVgC6r6");
        
        session.save(student);
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);
        session.save(student6);
        session.save(student7);
        session.save(student8);
        session.save(student9);
*/
        
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}

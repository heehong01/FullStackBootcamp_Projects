package admin;

import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class CreateStudentTable {
    public CreateStudentTable(Session session) {

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

    }

    private void addStudent(Session session, String email, String name, String password) {
        Student student = new Student(email, name, password, new ArrayList<>());
        session.save(student);
    }
}

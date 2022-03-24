package jpa.entitymodels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import jdk.jfr.Name;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="Student")
public class Student {

    @Id
    private String sEmail;
    private String sName;
    private String sPass;

    @ManyToMany(targetEntity = Course.class, cascade = {CascadeType.ALL})
    private List<Course> sCourses;

    //No arg constructor
    public Student(){
    }
    public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
        super();
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.sCourses = sCourses;
    }


    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getsCourses() {
        return sCourses;
    }

    public void setsCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }

}

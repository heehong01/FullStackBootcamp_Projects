package jpa.entitymodels;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="Student")
public class Student {

    @Id
    @Column(name="email", nullable = false, length = 50)
    private String sEmail;

    @Column(name="name", nullable = false, length = 50)
    private String sName;

    @Column(name="password", nullable = false, length = 50)
    private String sPass;

    @ManyToMany(targetEntity = Course.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name="Student_Course",
                joinColumns = @JoinColumn(name="id"),
                inverseJoinColumns = @JoinColumn(name="email"))
    private List<Course> sCourses;

    //No arg constructor
    public Student(){
    }
    public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return Objects.equals(sEmail, student.sEmail) && Objects.equals(sName, student.sName) && Objects.equals(sPass, student.sPass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sEmail, sName, sPass);
    }
}

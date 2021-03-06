package jpa.entitymodels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Course")
public class Course {

    @Id
    @Column(name="id", nullable = false)
    private int cId;
    @Column(name="name", nullable = false, length = 50)
    private String cName;
    @Column(name="Instructor", nullable = false, length = 50)
    private String cInstructorName;


    public Course(){

    }

    public Course(int cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }


    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Course course = (Course) o;
        return cId == course.cId && Objects.equals(cName, course.cName) && Objects.equals(cInstructorName, course.cInstructorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId, cName, cInstructorName);
    }
}

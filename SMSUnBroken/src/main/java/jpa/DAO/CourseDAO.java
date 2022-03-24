package jpa.DAO;

import jpa.entitymodels.Course;
import java.util.List;

public interface CourseDAO {
    public List<Course> getAllCourses();
}

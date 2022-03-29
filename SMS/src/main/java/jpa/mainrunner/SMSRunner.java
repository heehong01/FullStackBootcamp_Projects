package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import admin.StudentAndCourseTablesInitialization;
import jpa.Service.CourseService;
import jpa.Service.StudentService;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;



///ADD INPUT MISMATCH EXCEPTION
public class SMSRunner {
    private Scanner input;
    private StringBuilder sb;

    private CourseService courseService;
    private StudentService studentService;
    private Student currentStudent;

    public SMSRunner(){
        input = new Scanner(System.in);
        sb = new StringBuilder();
        courseService = new CourseService();
        studentService = new StudentService();
        new StudentAndCourseTablesInitialization();

    }

    public static void main(String[] args) {
        SMSRunner sms = new SMSRunner();
        sms.run();
    }

    private void run() {
        //Login or Quit
        switch(mainMenu()){
            case 1:
                if(studentLogin()){
                    registerMenu();
                }
                break;

            case 2:
                System.out.println("Goodbye!");
                break;
        }
    }

    private int mainMenu() {
        System.out.printf("1. Student Login\n" +
                "2. Quit Application\n" +
                "Please Enter Selection: \n");
        return input.nextInt();
    }


    private boolean studentLogin() {
        boolean returnValue = false;
        System.out.println("Enter your email address: ");
        String email = input.next();
        System.out.println("Enter your password: ");
        String password = input.next();

        Student student =  studentService.getStudentByEmail(email);
        if(student != null){
            currentStudent = student;
        }
        if(currentStudent != null && studentService.validateStudent(email, password)){
            List<Course> courses = studentService.getStudentCourses(email);
            System.out.println("My Classes");
            for(Course course : courses){
                System.out.println(course);
            }
            returnValue = true;
        }
        else{
            System.out.println("User Validation failed. GoodBye!");
        }
        return returnValue;
    }

    private void registerMenu() {
        List<Course> studentCourse = studentService.getStudentCourses(currentStudent.getsEmail());
        System.out.printf("Courses %s is registered in:\n", currentStudent.getsEmail());
        System.out.printf("%5s%30s%30s\n", "ID", "Course", "Instructor");
        for(Course course : studentCourse){
            System.out.printf("%5d%30s%30s\n",
                    course.getcId(),
                    course.getcName(),
                    course.getcInstructorName());
        }
        System.out.println();
        System.out.printf("1. Register a class\n" +
                "2. Logout\n" +
                "Please Enter Selection: \n");

        switch (input.nextInt()){
            case 1:
                System.out.println("WORKING1");
                List<Course> allCourses = courseService.getAllCourses();
                System.out.printf("%5s%30s%30s\n", "ID", "Course", "Instructor");
                for(Course course : allCourses) {
                    System.out.printf("%5d%30s%30s\n",
                            course.getcId(),
                            course.getcName(),
                            course.getcInstructorName());
                }

                System.out.println();
                System.out.println("Enter Course Number: ");
                int courseId = input.nextInt();
                studentService.registerStudentToCourse(currentStudent.getsEmail(), courseId);
                studentCourse = studentService.getStudentCourses(currentStudent.getsEmail());
                System.out.printf("Courses %s is registered in:\n", currentStudent.getsEmail());
                System.out.printf("%5s%30s%30s\n", "ID", "Course", "Instructor");

                for(Course course : studentCourse){
                    System.out.printf("%5d%30s%30s\n",
                            course.getcId(),
                            course.getcName(),
                            course.getcInstructorName());
                }
                System.out.println();
                break;

            case 2:
            default:
                System.out.println("GoodBye!");
        }
    }


}

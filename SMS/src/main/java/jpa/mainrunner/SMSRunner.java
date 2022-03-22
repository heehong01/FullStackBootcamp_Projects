package jpa.mainrunner;

import java.util.Scanner;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class SMSRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Are you a(n)\n" +
                "1. Student\n" +
                "2. quit\n" +
                "Please, enter 1 or 2\n");
        while(input.nextInt() != 2){
            input.nextLine();
            System.out.println("Enter Your Email:");
            String email = input.nextLine();
            System.out.println(email);
            System.out.println("Enter Your Password:");
            String password = input.nextLine();
            System.out.println(password);
        }
        System.out.println("You have been signed out.");
        input.close();
    }
    /*main -

-This method displays and prompts the user to select one of the following with the  option:



1. Student: This allows the user to enter his/her email and password and check whether or not those credentials are valid, in order to log in. If the credentials are invalid the program should end with an appropriate message to the student.



If the credentials are valid, the student is logged in and all the classes the Student is registered to should be displayed. Displays and prompt the student to select one of the following two additional numeric (1 or 2) options that are available:

·   1) Register to Class: This displays all the courses in the database and allows the student to select a course in which the student wished to be registered. If the Student is already registered in that course, display the message "You are already registered in that course!", otherwise, register the student to that course and save this result in your database. Also, show the updated registered courses list for that student. After that end the program with an appropriate message.

·   2) Logout: Which ends the program with an appropriate message.



2. quit: which ends the program with an appropriate message.*/

}

package com.ManagerAndTrainee;

public class InheritanceActivity {
    public static void main(String[] args){
        //Test Case 1
        //Initiate the manager with information and calculate salary
        Manager m1 = new Manager(126534, "Peter", "Chennai India", 237844, 65000);
        System.out.println(m1.calculateSalary());
        System.out.println(m1.calculateTransportAllowance());

        //Test Case 2
        //Creating an instance of trainee with information and calculate salary
        Trainee t1 = new Trainee(29846, "Jack", "Mumbai India", 442085, 45000);
        System.out.println(t1.calculateSalary());
        System.out.println(t1.calculateTransportAllowance());
    }
}

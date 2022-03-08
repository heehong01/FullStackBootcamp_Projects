package com.ManagerAndTrainee;

public class Trainee extends Employee {
    public Trainee(long Id, String Name, String Address, long phone, double basicSalary){
        super(Id, Name, Address, phone);
        super.setBasicSalary(basicSalary);
    }


}

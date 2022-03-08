package com.ManagerAndTrainee;

public class Manager extends Employee {
    public Manager(long Id, String Name, String Address, long phone, double basicSalary){
        super(Id, Name, Address, phone);
        super.setBasicSalary(basicSalary);
    }
    @Override
    public double calculateTransportAllowance(){
        double transportAllowance = 0.15 * super.getBasicSalary();
        return transportAllowance;
    }
}

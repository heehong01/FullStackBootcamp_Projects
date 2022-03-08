package com.ManagerAndTrainee;

public class Employee {
    private long employeeId;
    private String employeeName;
    private String employeeAddress;
    private long employeePhone;
    private double basicSalary;
    private double specialAllowance = 250.80;
    private double Hra = 1000.50;

    public Employee(long Id, String Name, String Address, long phone){
        this.employeeId = Id;
        this.employeeName = Name;
        this.employeeAddress = Address;
        this.employeePhone = phone;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double calculateSalary(){
        double salary = basicSalary
                + (basicSalary * (specialAllowance / 100))
                + (basicSalary * (Hra / 100));
        return salary;
    }

    public double calculateTransportAllowance(){
        double transportAllowance = 0.1 * basicSalary;
        return transportAllowance;
    }


}

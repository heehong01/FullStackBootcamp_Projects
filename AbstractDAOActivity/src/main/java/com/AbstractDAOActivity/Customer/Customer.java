package com.heejinhong.AbstractDAOActivity.Customer;

public class Customer {

    private int id;
    private String email;
    private String fName;
    private String lName;

    public Customer (int id, String email, String fName, String lName){
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
    }

    public Customer(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }


}

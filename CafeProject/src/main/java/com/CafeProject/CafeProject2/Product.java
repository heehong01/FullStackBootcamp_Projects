package com.CafeProject.CafeProject2;

public abstract class Product {
    private String name;
    private double price;
    private String description;
    private int quantity;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(){

    }

    public Product(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public abstract double calculateProductTotal();
    /*public void calculateProductTotal(){
        double subtotal = getPrice()*getQuantity();
        double total = subtotal + subtotal*SALES_TAX;
        System.out.printf("\n%-20s: $%.2f\n", ("Subtotal for " + getName()), subtotal);
        System.out.printf("%-20s: $%.2f\n", "Sales Tax", subtotal*SALES_TAX);
        System.out.printf("%-20s: $%.2f\n\n", ("Total for "+ getName()),total);
    }*/


}

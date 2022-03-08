package com.CafeProject.CafeProject3;

public class Cappuccino extends Product {

    boolean peppermint, whippedCream;

    public Cappuccino(){
        this.peppermint = false;
        this.whippedCream = false;
    }
    public Cappuccino(String name, double price, String description, boolean peppermint, boolean whippedCream){
        super(name, price, description);
        this.peppermint = peppermint;
        this.whippedCream = whippedCream;
    }
    public boolean isPeppermint() {
        return peppermint;
    }

    public void setPeppermint(boolean peppermint) {
        this.peppermint = peppermint;
    }

    public boolean isWhippedCream() {
        return whippedCream;
    }

    public void setWhippedCream(boolean whippedCream) {
        this.whippedCream = whippedCream;
    }

    @Override
    public double calculateProductTotal() {
        double subtotal = super.getQuantity()*super.getPrice();
        if(peppermint == true){
            subtotal += super.getQuantity()*2.00;
        }
        else if(whippedCream == true){
            subtotal += super.getQuantity()*1.00;
        }
        return subtotal;
    }

    @Override
    public void addOptions(){
        System.out.println();
    }

    @Override
    public void printOptions(){
        System.out.println();
    }

}

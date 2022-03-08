package com.CafeProject.CafeProject3;

public class Espresso extends Product {
     boolean extraShot, macchiato;

    public Espresso() {
        this.extraShot = false;
        this.macchiato = false;
    }

    public Espresso(String name, double price, String description, boolean extraShot, boolean macchiato){
        super(name, price, description);
        this.extraShot = extraShot;
        this.macchiato = macchiato;
    }

    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isMacchiato() {
        return macchiato;
    }

    public void setMacchiato(boolean macchiato) {
        this.macchiato = macchiato;
    }

    @Override
    public double calculateProductTotal() {
        double subtotal = super.getQuantity()*super.getPrice();
        if(extraShot == true){
            subtotal += super.getQuantity()*2.00;
        }
        else if(macchiato == true){
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

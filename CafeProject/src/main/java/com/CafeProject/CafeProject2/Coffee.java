package com.CafeProject.CafeProject2;

public class Coffee extends Product{
    boolean sugar, milk;

    public Coffee(){
        super();
        this.milk = false;
        this.sugar = false;
    }

    public Coffee(String name, double price, String description, boolean sugar, boolean milk){
        super(name, price, description);
        this.milk = milk;
        this.sugar = sugar;
    }

    public boolean isSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    @Override
    public double calculateProductTotal() {
        return super.getQuantity()*super.getPrice();
    }
}

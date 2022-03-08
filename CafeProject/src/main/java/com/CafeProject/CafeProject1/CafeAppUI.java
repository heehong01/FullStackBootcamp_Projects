package com.CafeProject.CafeProject1;

import java.util.Scanner;

public class CafeAppUI {
    static void startCafeApp() {
        Product coffee = new Product();
        coffee.setName("Coffee");
        coffee.setPrice(2.99);
        coffee.setDescription("Pour Over style coffee made from Light Roast Coffee Beans from Hawaii.");

        Product espresso = new Product();
        espresso.setName("Espresso");
        espresso.setPrice(3.99);
        espresso.setDescription("The simplest drink to prepare, an espresso is a single shot of coffee, usually served in a small demitasse cup.");

        Product cappuccino = new Product();
        cappuccino.setName("Cappuccino");
        cappuccino.setPrice(4.99);
        cappuccino.setDescription("A single shot of espresso, topped up with steamed milk, served in a cup 150ml-200ml in size, and topped with a dusting of chocolate powder");

        System.out.println("CafeApp Starting... please wait a moment\n");
        System.out.println("Welcome to CafeApp What would you like to order?\n");
        boolean continueLoop = true;
        Scanner input = new Scanner(System.in);
        try{
            while(continueLoop){
                coffeeOrderPrintStatement();
                String coffeeName = stringFirstLetterUpperCase(input.next());
                if(coffeeName.equals(coffee.getName())){
                    productQuantityInput(coffee, input);
                }
                else if(coffeeName.equals(espresso.getName())){
                    productQuantityInput(espresso, input);
                }
                else if(coffeeName.equals(cappuccino.getName())){
                    productQuantityInput(cappuccino, input);
                }
                else if(coffeeName.equals("Exit")){
                    continueLoop = false;
                    continue;
                }
                //else{
                //    System.out.println("Please enter the right drink item");
                //}
                continueLoop = orderMore(continueLoop, input);
            }
        }
        catch (Exception e){
            System.out.println("Needed to enter a STRING value!");
        }
        exitOutputSubTotalSubTotalAndTaxAndFinalTotal(coffee, espresso, cappuccino);
        input.close();
    }

    private static void exitOutputSubTotalSubTotalAndTaxAndFinalTotal(Product coffee, Product espresso, Product cappuccino) {
        double total;
        double subtotalAndTax;
        double subtotal;
        subtotal = coffee.calculateProductTotal() + espresso.calculateProductTotal() + cappuccino.calculateProductTotal();
        subtotalAndTax = subtotal*0.08;
        total = subtotal + subtotalAndTax;
        System.out.printf("%-20s: $\n", "Subtotal", subtotal);
        System.out.printf("%-20s: $\n", "Total Sales Tax", subtotalAndTax);
        System.out.printf("%-20s: $\n", "Total", total);
        System.out.println("Thank you and have a good day!");
    }

    private static String stringFirstLetterUpperCase(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }

    private static boolean orderMore(boolean continueLoop, Scanner input) {
        System.out.println("Would you like to order more? Yes or No");
        String repeat = stringFirstLetterUpperCase(input.next());

        if(repeat.equals("Yes")){
            return continueLoop = true;
        }
        else if(repeat.equals("No")){
            continueLoop = false;
        }
        return continueLoop;
    }

    private static void coffeeOrderPrintStatement() {
        System.out.println("MENU:");
        System.out.println("Coffee:     2.99");
            System.out.println("Espresso:   3.99");
            System.out.println("Cappuccino: 4.99\n");
            System.out.println("Please enter the name of your drink and the quantity of your product.");
            System.out.println("Type exit to quit CafeApp");
        }

        private static void productQuantityInput(Product coffeeType, Scanner input) {
            try{
                System.out.println("How many " + coffeeType.getName() + " would you like?");
                coffeeType.setQuantity(input.nextInt());
                double subtotal = coffeeType.calculateProductTotal();
                System.out.println(coffeeType.getName() + ": " + coffeeType.getDescription());
                System.out.println("Subtotal is " + subtotal);
            }catch(Exception e){
                System.out.println("Needed to enter an INTEGER value for the quantity of " + coffeeType.getName());
        }
    }


}

import java.util.Scanner;

public class FtoC{
    public static void main(String[] args){
    //c = (5/9)(f-32)
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the farenheit that you want to convert (in Double format: ex. 68.0).");
        double fahrenheit = input.nextDouble();
        double celcius = (5.0/9.0)*(fahrenheit-32.0);
        System.out.printf("%.2f Farenheit is %.2f Celcius\n", fahrenheit, celcius);

    }
}
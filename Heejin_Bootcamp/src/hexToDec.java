import java.util.Scanner;

public class hexToDec {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a hexadecimal value: (0-9; A-F)");
        String character = input.nextLine();

        if(character.length()> 1) {
            System.out.println("ERROR you entered more than one value! EX: 1; A");
        }
        try {
            int convertedInteger = Integer.valueOf(character, 16);
            System.out.println("The decimal value of " + character+ " is " + convertedInteger);
        }catch (Exception e){
            System.out.println("You did not put in a hexadecimal value.");
        }

    }
}

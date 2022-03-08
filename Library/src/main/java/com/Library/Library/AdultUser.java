package com.Library.Library;

public class AdultUser implements LibraryUser{
    private int age;
    private String bookType;

    @Override
    public void registerAccount(int age) {
        if(age > 12){
            System.out.println("You have successfully registered under a Adult Account");
        }
        if(age < 12){
            System.out.println("Sorry, Age must be greater than 12 to register as an adult");
        }
    }

    @Override
    public void requestBook(String bookType) {
        if(bookType.equals("Fiction")){
            System.out.println("Book Issued successfully, please return the book within 7 days");
        }
        else{
            System.out.println("Oops, you are allowed to take only adult Fiction books");
        }
    }
}
/*
The methods in the AdultUser class should perform the following logic.

1. registerAccount : if age > 12, a message displaying “You have
successfully registered under an Adult Account” should be displayed in

the console.
If age<12, a message displaying, “Sorry, Age must be greater than 12
to register as an adult” should be displayed in the console.
2. requestBook : if bookType is “Fiction”, a message displaying “Book Issued
successfully, please return the book within 7 days” should be displayed in
the console.
else, a message displaying, “Oops, you are allowed to take only adult
Fiction books” should be displayed in the console.
 */
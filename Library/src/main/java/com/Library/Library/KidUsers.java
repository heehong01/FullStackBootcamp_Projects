package com.Library.Library;

public class KidUsers implements LibraryUser{
    private int age;
    private String bookType;

    @Override
    public void registerAccount(int age) {
        if(age < 12){
            System.out.println("You have successfully registered under a Kids Account");
        }
        if(age > 12){
            System.out.println("Sorry, Age must be less than 12 to register as a kid");
        }
    }

    @Override
    public void requestBook(String bookType) {
        if(bookType.equals("Kids")){
            System.out.println("Book Issued successfully, please return the book within 10 days");
        }
        else{
            System.out.println("Oops, you are allowed to take only kids books");
        }
    }
}

/*4.
 The methods in the KidUser class should perform the following logic.

1. registerAccount : if age < 12, a message displaying “You have successfully
registered under a Kids Account” should be displayed in the console.
If(age>12), a message displaying, “Sorry, Age must be less than 12 to
register as a kid” should be displayed in the console.

2. requestBook : if bookType is “Kids”, a message displaying “Book Issued
successfully, please return the book within 10 days” should be displayed in the
console.
else, a message displaying, “Oops, you are allowed to take only kids
books” should be displayed in the console.*/
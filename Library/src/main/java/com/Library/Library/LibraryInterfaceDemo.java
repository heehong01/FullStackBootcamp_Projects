package com.Library.Library;

public class LibraryInterfaceDemo {
    public static void main(String[] args) {
        KidUsers newkid = new KidUsers();
        newkid.registerAccount(10);
        newkid.registerAccount(18);
        newkid.requestBook("Kids");
        newkid.requestBook("Fiction");

        AdultUser newAdult = new AdultUser();
        newAdult.registerAccount(5);
        newAdult.registerAccount(23);
        newAdult.requestBook("Kids");
        newAdult.requestBook("Fiction");
    }
}

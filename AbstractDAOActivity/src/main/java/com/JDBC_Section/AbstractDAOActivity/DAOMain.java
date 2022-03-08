package com.AbstractDAOActivity;

import java.sql.SQLException;
import java.util.List;

import com.AbstractDAOActivity.Customer.*;
import com.AbstractDAOActivity.Item.*;
import com.AbstractDAOActivity.mydb.*;

public class DAOMain {
    public static void main(String[] args) {
        CustomerDAOI customerDAOI = new CustomerDAOImpl();
        ItemDAOI itemDAOI = new ItemDAOImpl();

        itemInsertDeleteAndGetAllItemFunctions(itemDAOI);

        customerGetAddAndRemoveCustomer(customerDAOI);
    }

    private static void customerGetAddAndRemoveCustomer(CustomerDAOI customerDAOI) {
        System.out.println("Getting Customer by ID ");

        Customer customer = customerDAOI.getCustomerById(5);
        printCustomer(customer);

        System.out.println();
        System.out.println("Adding New Customer");

        Customer addCustomer = new Customer(6, "heehong01@gmail.com", "Heejin", "Hong");
        customerDAOI.addCustomer(addCustomer);

        System.out.println();
        System.out.println("Removing Customer by ID");

        customerDAOI.removeCustomerById(1);

        System.out.println("Getting customer at ID that is removed and seeing if there is any value");
        Customer removedcustomer = customerDAOI.getCustomerById(1);
        printCustomer(removedcustomer);

        System.out.println();
    }



    private static void itemInsertDeleteAndGetAllItemFunctions(ItemDAOI itemDAOI) {
        System.out.println("Getting all items");
        List<Item> getAllItem = itemDAOI.getAllItems();
        printItem(getAllItem);

        System.out.println();
        System.out.println("Inserting new Item");

        Item insert = new Item(5, "FIVE WATT", 16.99);
        itemDAOI.addItem(insert);
        List<Item> allItems = itemDAOI.getAllItems();
        printItem(allItems);

        System.out.println();
        System.out.println("Removing an Item by ID");

        itemDAOI.removeItemById(4);
        List<Item> allItemsUpdated = itemDAOI.getAllItems();
        printItem(allItemsUpdated);

        System.out.println();
    }

    private static void printItem(List<Item> allItems) {
        allItems.forEach(item
                -> System.out.println("Item info: "
                + item.getId() + " "
                + item.getName() + " "
                + item.getPrice()));
        System.out.println();
    }
    private static void printCustomer(Customer customer) {
        System.out.println("Customer at ID: " + customer.getId()
                + " | " + customer.getEmail()
                + " | " + customer.getFName()
                + " | " + customer.getLName());
        System.out.println();
    }
}
/*Database Tables:
Customer - id(int), email(varchar2), fname(varchar2), lname(varchar2).
Item - id(int), name(varchar2), price(Number(4,2)).
Create models for each table.
Create DAOs with the following methods:
CustomerDAO
getCustomerById(int id) - Returns the customer object for the given id.
addCustomer(Customer c) - Adds a customer with given information.
removeCustomerById(int id) - Removes a customer with the given id.
ItemDAO
getAllItems() - Returns a list of all item objects in the database.
addItem(Item i) - Adds an item with given information.
removeItemById(int id) - Removes an item with the given id.
*/

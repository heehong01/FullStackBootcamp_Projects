package com.heejinhong.AbstractDAOActivity.mydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.heejinhong.AbstractDAOActivity.Constants.*;

public class CreateCustomersTable {
    public static void createCustomersTable(){
        String url = JDBC_MYSQL_LOCALHOST_MYDB;
        Connection con;
        String createString;
        createString = "CREATE TABLE customer" +
                "(id int, " +
                "email varchar(32), " +
                "fName varchar(32), " +
                "lName varchar(32))";
        Statement stmt;

        try{
            Class.forName(MYSQL_CJ_JDBC_DRIVER);

        }catch(java.lang.ClassNotFoundException e){
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try{
            con = DriverManager.getConnection(url, USERNAME, PASSWORD);

            stmt = con.createStatement();
            stmt.executeUpdate(createString);

            System.out.println("Customer Table is successfully created");

            stmt.close();
            con.close();

        }catch (SQLException ex){
            System.err.println("SQLException: "+ ex.getMessage());
        }
    }
}

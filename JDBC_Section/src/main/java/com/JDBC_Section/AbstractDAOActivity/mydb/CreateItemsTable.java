package com.JDBC_Section.AbstractDAOActivity.mydb;

import com.JDBC_Section.AbstractDAOActivity.Constants;

import java.sql.*;

public class CreateItemsTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection con;
        String createString;
        createString = "CREATE TABLE item" +
                "(id INT , " +
                "name VARCHAR(32), " +
                "price DECIMAL(4,2))";
        Statement stmt;

        try{
            Class.forName(Constants.MYSQL_CJ_JDBC_DRIVER);

        }catch(java.lang.ClassNotFoundException e){
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try{
            con = DriverManager.getConnection(url, Constants.USERNAME, Constants.PASSWORD);

            stmt = con.createStatement();
            stmt.executeUpdate(createString);

            System.out.println("Items Table is successfully created");

            stmt.close();
            con.close();

        }catch (SQLException ex){
            System.err.println("SQLException: "+ ex.getMessage());
        }
    }
}

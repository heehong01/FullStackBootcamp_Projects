package com.JDBC_Section.AbstractDAOActivity.mydb;

import com.JDBC_Section.AbstractDAOActivity.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropCustomerTable {
    public static void main(String[] args) {
        String url = Constants.JDBC_MYSQL_LOCALHOST_MYDB;
        Connection con;
        String dropString = "DROP TABLE customer";
        Statement stmt;

        try{
            Class.forName(Constants.MYSQL_CJ_JDBC_DRIVER);
        }catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try{
            con = DriverManager.getConnection(url, Constants.USERNAME, Constants.PASSWORD);
            stmt = con.createStatement();
            stmt.executeUpdate(dropString);

            System.out.println("CUSTOMER table is successfully dropped");
            stmt.close();
            con.close();
        }catch (SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}

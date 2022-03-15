package com.heejinhong.AbstractDAOActivity.mydb;

import com.heejinhong.AbstractDAOActivity.Item.ItemDAOI;

import java.sql.*;

import static com.heejinhong.AbstractDAOActivity.Constants.*;

public class CreateItemsTable {
    public static void createItemsTable() {
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection con;
        String createString;
        createString = "CREATE TABLE item" +
                "(id INT , " +
                "name VARCHAR(32), " +
                "price DECIMAL(4,2))";
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

            System.out.println("Items Table is successfully created");

            stmt.close();
            con.close();

        }catch (SQLException ex){
            System.err.println("SQLException: "+ ex.getMessage());
        }
    }
}

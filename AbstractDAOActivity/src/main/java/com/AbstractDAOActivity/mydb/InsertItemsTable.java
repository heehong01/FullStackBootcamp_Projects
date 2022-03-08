package com.AbstractDAOActivity.mydb;

import java.sql.*;

import static com.AbstractDAOActivity.Constants.*;
import static com.AbstractDAOActivity.Constants.PASSWORD;

public class InsertItemsTable {
    public static void insertItemsTable(){
        String url = JDBC_MYSQL_LOCALHOST_MYDB;
        Connection con;
        Statement stmt;
        String query = "SELECT * FROM item";

        try{
            Class.forName(MYSQL_CJ_JDBC_DRIVER);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: " +
                    e.getMessage());
        }
        try{
            con = DriverManager.getConnection(url, USERNAME, PASSWORD);
            stmt = con.createStatement();

            stmt.executeUpdate("INSERT INTO ITEM " +
                    "VALUES(1, 'SPYHOUSE COFFEE', 12.99)");
            stmt.executeUpdate("INSERT INTO ITEM "  +
                    "VALUES(2, 'COLLECTIVO COFFEE', 15.99)");
            stmt.executeUpdate("INSERT INTO ITEM "  +
                    "VALUES(3, 'DOGWOOD COFFEE', 14.99)");
            stmt.executeUpdate("INSERT INTO ITEM "  +
                    "VALUES(4, 'INTELLIGENTE COFFEE', 14.99)");

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Item and prices");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                System.out.println(id + " | " + name + " | " + price);
            }
            System.out.println();
            stmt.close();
            con.close();
        }catch (SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}

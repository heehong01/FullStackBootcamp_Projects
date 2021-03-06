package com.JDBC_Section.AbstractDAOActivity.mydb;

import com.JDBC_Section.AbstractDAOActivity.Constants;

import java.sql.*;

public class InsertCustomersTable {
    public static void main(String[] args) {
        String url = Constants.JDBC_MYSQL_LOCALHOST_MYDB;
        Connection con;
        Statement stmt;
        String query = "SELECT * FROM customer";
        try{
            Class.forName(Constants.MYSQL_CJ_JDBC_DRIVER);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: " +
                    e.getMessage());
        }
        try{
            con = DriverManager.getConnection(url, Constants.USERNAME, Constants.PASSWORD);
            stmt = con.createStatement();

            stmt.executeUpdate("INSERT INTO CUSTOMER " +
                    "VALUES(1, 'user1@email.com', 'user', 'one' )");
            stmt.executeUpdate("INSERT INTO CUSTOMER " +
                    "VALUES(2, 'user2@email.com', 'jane', 'doe')");
            stmt.executeUpdate("INSERT INTO CUSTOMER " +
                    "VALUES(3, 'user3@email.com', 'temperance', 'brennan')");
            stmt.executeUpdate("INSERT INTO CUSTOMER " +
                    "VALUES(4, 'user4@email.com', 'seeley', 'booth')");
            stmt.executeUpdate("INSERT INTO CUSTOMER " +
                    "VALUES(5, 'user5@email.com', 'johnny', 'boy')");

            //Perform the query
            ResultSet rs = stmt.executeQuery(query);

            //DISPLAY ROWS
            System.out.println("Customer information");
            while(rs.next()){
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                System.out.println(id + " | " +
                        email + " | " +
                        fName + " | " + lName);
            }
            System.out.println();
            stmt.close();
            con.close();
        }catch (SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}

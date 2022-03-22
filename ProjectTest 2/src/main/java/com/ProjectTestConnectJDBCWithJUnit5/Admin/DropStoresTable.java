package com.ProjectTestConnectJDBCWithJUnit5.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ProjectTestConnectJDBCWithJUnit5.Constants.*;
public class DropStoresTable {
    public static void dropStoresTable(){

        String url = JDBC_MARIADB_LOCALHOST_MYDB;
        Connection con;
        String dropString = "DROP TABLE Stores";
        Statement stmt;
        try{
            Class.forName(MARIADB_CJ_JDBC_DRIVER);
        }catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

            try{
            con = DriverManager.getConnection(url, USERNAME, PASSWORD);
            stmt = con.createStatement();
            stmt.executeUpdate(dropString);

            System.out.println("STORES table is successfully dropped");
            stmt.close();
            con.close();
        }catch (SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}

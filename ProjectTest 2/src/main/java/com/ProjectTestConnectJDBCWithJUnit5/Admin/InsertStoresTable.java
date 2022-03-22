package com.ProjectTestConnectJDBCWithJUnit5.Admin;

import java.sql.*;
import static com.ProjectTestConnectJDBCWithJUnit5.Constants.*;
public class InsertStoresTable {
    public static void InsertStoresTable(){
        String url = JDBC_MARIADB_LOCALHOST_MYDB;
        Connection con;
        Statement stmt;
        String query = "SELECT * FROM Stores";
        try{
            Class.forName(MARIADB_CJ_JDBC_DRIVER);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: " +
                    e.getMessage());
        }
        try{
            con = DriverManager.getConnection(url, USERNAME, PASSWORD);
            stmt = con.createStatement();

            stmt.executeUpdate("INSERT INTO Stores " +
                    "VALUES(1, 'GAP', 'Minneapolis', 'Minnesota')");
            stmt.executeUpdate("INSERT INTO Stores " +
                    "VALUES(2, 'Piggly Wiggly', 'Minneapolis', 'Minnesota')");
            stmt.executeUpdate("INSERT INTO Stores " +
                    "VALUES(3, 'Uniqlo', 'Chicago', 'Illinois')");
            stmt.executeUpdate("INSERT INTO Stores " +
                    "VALUES(4, 'Ross', 'Phoenix', 'Arizona')");
            stmt.executeUpdate("INSERT INTO Stores " +
                    "VALUES(5, 'JCPenny', 'Clovis', 'New Mexico')");
            stmt.executeUpdate("INSERT INTO Stores " +
                    "VALUES(6, 'Apple', 'Santa Clara', 'California')");

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

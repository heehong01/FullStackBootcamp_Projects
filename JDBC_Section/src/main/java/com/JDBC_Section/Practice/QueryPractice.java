package com.JDBC_Section.Practice;

import java.sql.*;


public class QueryPractice {

    /*public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/classicmodels";
        final String USER = "root";
        final String PASS = "Password1";

        Connection conn = DriverManager.getConnection(url, USER, PASS);

        String query1 = "SELECT * FROM EMPLOYEES";
        PreparedStatement ps = conn.prepareStatement(query1);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String fname = rs.getString("firstname");
            String lname = rs.getString("lastname");
            System.out.println("First and Last NAME of EMPLOYEE: " + fname + " " + lname);
        }

        System.out.println();

        String query2 = "SELECT * FROM EMPLOYEES WHERE officecode = ?";
        ps = conn.prepareStatement(query2);
        ps.setInt(1, 1);
        rs = ps.executeQuery();
        while(rs.next()){
            String fname = rs.getString("firstname");
            String lname = rs.getString("lastname");
            System.out.println("First and Last NAME of EMPLOYEE: " + fname + " " + lname);
        }

        System.out.println();
        String query3 = "SELECT * FROM EMPLOYEES WHERE officecode = ? AND firstname = ?";
        ps = conn.prepareStatement(query3);
        ps.setInt(1, 1);
        ps.setString(2, "Leslie");
        rs = ps.executeQuery();
        while(rs.next()){
            String fname = rs.getString("firstname");
            String lname = rs.getString("lastname");
            System.out.println("First and Last NAME of EMPLOYEE: " + fname + " " + lname);
        }
    }*/


}

package com.heejinhong.AbstractDAOActivity.Customer;

import com.heejinhong.AbstractDAOActivity.AbstractDAO;
import com.heejinhong.AbstractDAOActivity.Item.ItemDAOI;

import java.sql.SQLException;

public class CustomerDAOImpl
        extends AbstractDAO
        implements CustomerDAOI {
    @Override
    public Customer getCustomerById(int id) {
        Customer customer = new Customer();
        try{
            this.connect();
            ps = conn.prepareStatement(SQL.GET_CUSTOMER_BY_ID.getQuery());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                customer.setId(rs.getInt(1));
                customer.setEmail(rs.getString(2));
                customer.setFName(rs.getString(3));
                customer.setLName(rs.getString(4));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.dispose();
            return customer;
        }
    }

    @Override
    public void addCustomer(Customer c) {
        try{
            this.connect();

            ps = conn.prepareStatement(SQL.ADD_CUSTOMER.getQuery());
            ps.setInt(1,c.getId());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getFName());
            ps.setString(4, c.getLName());
            ps.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.dispose();
            System.out.println("Successfully added to the table");
        }
    }

    @Override
    public void removeCustomerById(int id) {
        try{
            this.connect();

            ps = conn.prepareStatement(SQL.REMOVE_CUSTOMER.getQuery());
            ps.setInt(1, id);
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.dispose();
            System.out.println("Successfully removed");
        }
    }
}

package com.JDBC_Section.AbstractDAOActivity.Item;

import com.JDBC_Section.AbstractDAOActivity.AbstractDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl
        extends AbstractDAO
        implements ItemDAOI {
    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try {
            this.connect();
            ps = conn.prepareStatement(SQL.GET_ALL_ITEM.getQuery());
            rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setPrice(rs.getDouble(3));
                items.add(item);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.dispose();
            return items;
        }
    }

    @Override
    public void addItem(Item i) {
        try{
            this.connect();

            ps = conn.prepareStatement(SQL.ADD_ITEM.getQuery());
            ps.setInt(1, i.getId());
            ps.setString(2, i.getName());
            ps.setDouble(3, i.getPrice());
            //CATCHES AN ERROR IN QUERY
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.dispose();
            System.out.println("Successfully added item");
        }
    }

    @Override
    public void removeItemById(int id) {
        try{
            this.connect();

            ps = conn.prepareStatement(SQL.REMOVE_ITEM_BY_ID.getQuery());
            ps.setInt(1, id);
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.dispose();
            System.out.println("Successfully removed the item by id");
        }
    }
}

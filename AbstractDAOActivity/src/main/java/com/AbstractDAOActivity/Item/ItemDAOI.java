package com.AbstractDAOActivity.Item;

import java.util.List;

public interface ItemDAOI {
    enum SQL{
        GET_ALL_ITEM("SELECT * FROM item"),
        ADD_ITEM("INSERT INTO item(id, name, price) VALUES(?, ?, ?)"),
        REMOVE_ITEM_BY_ID("DELETE FROM item where id = ?");
        private final String query;

        private SQL(String s) {
            this.query = s;
        }
        public String getQuery() {
            return query;
        }
    }
    List<Item> getAllItems();
    void addItem(Item i);
    void removeItemById(int id);
}

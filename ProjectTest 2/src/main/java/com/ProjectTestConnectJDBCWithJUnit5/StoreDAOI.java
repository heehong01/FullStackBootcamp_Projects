package com.ProjectTestConnectJDBCWithJUnit5;

public interface StoreDAOI {
    enum SQL {
        GET_ALL_STORES_BY_CITY("SELECT * FROM Stores WHERE city = ?");
        private final String query;

        private SQL(String s) {
            this.query = s;
        }
        public String getQuery(){
            return query;
        }
    }
    Stores getStoresByCity(String city);
}

package com.ProjectTestConnectJDBCWithJUnit5;


public class StoresDAOImpl
        extends AbstractDAO
        implements StoreDAOI{

    @Override
    public Stores getStoresByCity(String city) {
        Stores stores = new Stores();
        try{
            this.connect();
            ps = conn.prepareStatement(SQL.GET_ALL_STORES_BY_CITY.getQuery());
            ps.setString(1, city);
            rs = ps.executeQuery();
            if(rs.next()){
                stores.setId(rs.getInt(1));
                stores
            }

        }
    }
}

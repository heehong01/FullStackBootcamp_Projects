package com.JDBC_Section.AbstractDAOActivity;

import java.sql.*;

import static com.JDBC_Section.AbstractDAOActivity.Constants.*;

public abstract class AbstractDAO {

    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public void connect() throws SQLTransientConnectionException {
        try {
            Class.forName(MYSQL_CJ_JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_MYDB, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new SQLTransientConnectionException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dispose() {
        try {
            if (!rs.equals(null) && !rs.isClosed()) {
                rs.close();
            }
            if (!ps.equals(null) && !ps.isClosed()) {
                ps.close();
            }
            if (!conn.equals(null) && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


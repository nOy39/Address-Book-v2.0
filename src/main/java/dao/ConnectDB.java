package dao;

import helpers.Constant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Constant.getURL(),
                    Constant.getUSER(),
                    Constant.getPASSWORD());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

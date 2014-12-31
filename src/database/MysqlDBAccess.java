package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by reza on 12/31/14.
 */


public class MysqlDBAccess extends DBAccess {

    @Override
    public Connection getConnection(String url, String userName, String Password) {

        Connection con=null;
        try {
            con = DriverManager.getConnection(url,userName, Password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

}

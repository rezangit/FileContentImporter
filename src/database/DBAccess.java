package database;

import java.sql.Connection;

/**
 * Created by reza on 12/31/14.
 *
 */

public abstract class DBAccess {

    public abstract Connection getConnection(String url, String userName, String Password);

}

package plus.misterplus.weatherpi.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils {
    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

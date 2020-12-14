package plus.misterplus.weatherpi.sql.connection;

public class MasterDB extends DB {

    private static final MasterDB instance = new MasterDB();

    public static MasterDB getInstance() {
        return instance;
    }

    public MasterDB() {
        this.url = "jdbc:mariadb://localhost:3307/weatherpi";
        this.username = "root";
        this.pass = "password";
    }

}

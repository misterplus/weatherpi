package plus.misterplus.weatherpi.sql.connection;

public class NodeDB extends DB {

    public NodeDB(String address, String username, String pass) {
        this.url = String.format("jdbc:mariadb://%s:3307/weatherpi", address);
        this.username = username;
        this.pass = pass;
    }
}

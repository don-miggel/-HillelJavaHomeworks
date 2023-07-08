package conn;

import org.mariadb.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private String host;
    private String dbName;
    private String user;
    private String password;
    private final Connection conn;

    public DataBaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");

        initDatabaseCredentials();
        String url = String.format("%s/%s", host, dbName);

        this.conn =
                (Connection) DriverManager.getConnection(url, user, password);
    }

    private void initDatabaseCredentials(){
        host = System.getenv("JDBC_HOST");
        dbName = System.getenv("JDBC_DB_NAME");
        user = System.getenv("JDBC_USER");
        password = System.getenv("JDBC_PASSWORD");

    }

    public Connection getConnection(){
        return conn;
    }

    public void close(Connection conn){
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Unable to close a connection "+ e.getMessage());
            }
        }
    }

}

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection getConnection() throws SQLException {
    
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyCafe;encrypt=true;trustServerCertificate=true;";
        String user = "sa"; 
        String password = "sapassword";
        return DriverManager.getConnection(url, user, password);
    }
}
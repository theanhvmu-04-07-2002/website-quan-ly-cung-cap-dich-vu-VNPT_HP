import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testConnect {
    public static void main(String[] args) {
        String host = "localhost";
        String port = "1521";
        String serviceName = "DichVuVNPT";

        String jdbcUrl = String.format("jdbc:oracle:thin:@%s:%s:%s", host, port, serviceName);

        String username = "SYSTEM";
        String password = "a@B04072002A";

        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println("Service Name: " + serviceName);
        System.out.println("JDBC URL: " + jdbcUrl);

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection OK");
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection ERROR");
            System.err.println("Error: " + e.getMessage());
        }
    }
}

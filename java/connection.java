import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/console_schema","root","live4die");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}

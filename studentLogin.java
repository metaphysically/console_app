import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class studentLogin {
    static Scanner input = new Scanner(System.in);
    static String username, password;

    public static boolean validate(String username, String password) {
        boolean status = false;
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from studentLogin where username = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static void login() {
        System.out.println("  Student Login   ");
        System.out.print("Username: ");
        username = input.next();
        System.out.print("Password: ");
        password = input.next();

        if (validate(username, password)) {
            System.out.println("Logged in Successfully.");
            studentLoggedIn.main(new String[]{});
        }
        else {
            System.out.println("Failed to login. Please try again.");
            login();
        }

    }
    public static void main(String[] args) {
        login();
    }
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class teacherLogin {
    static Scanner input = new Scanner(System.in);
    static String username, password;
    public static boolean validate(String username, String password) {
        boolean status = false;
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from teacherLogin where username = ? and password = ?");
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

        System.out.println("  Teacher Login   ");
        System.out.print("Username: ");
        username = input.next();
        System.out.print("Password: ");
        password = input.next();

        if (validate(username, password)) {
            System.out.println("Logged in Successfully.");
            teacherLoggedIn.main(new String[]{});
        }
        else {
            System.out.println("Failed to login. Please try again.");
            System.out.println("Try again? Yes/No");
            String cancel = input.next();
            if (cancel.equalsIgnoreCase("Yes") || cancel.equalsIgnoreCase("y")) {
                login();
            }
            else {
                mainScript.main(new String[]{});
            }
        }
    }
    public static void main (String[] args) {
        login();
    }
}


import java.util.*;
public class adminLogin {
    static Scanner input = new Scanner(System.in);
    static String username = "admin";
    static String password = "admin123";
    static String user;
    static String pass;
    public static void input() {
        System.out.println("     Admin Login     ");
        System.out.print("Username: ");
        user = input.next();
        System.out.println();
        System.out.print("Password: ");
        pass = input.next();
        System.out.println();
    }
    public static void validate() {
        if (username.equals(user) && password.equals(pass)) {
            adminLoggedIn.main(new String[]{});
        }
        else {
            System.out.println("Wrong username or password entered.");
            input();
        }
    }
    public static void main(String[] args) {
        input();
        validate();
    }
}

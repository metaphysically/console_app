
import java.util.*;

public class mainScript {
    static char choice;
    public static void input() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 'A' for logging in as an admin");
        System.out.println("Enter 'S' for logging in as a student");
        System.out.println("Enter 'T' for logging in as a teacher");
        System.out.print("Logging in as: ");
        choice = input.next().charAt(0);
    }
    public static void validate() {
        if (choice == 'a' || choice == 'A') {
            adminLogin.main(new String[]{});
        }
        else if (choice == 's' || choice == 'S') {
            studentLogin.main(new String[]{});
        }
        else if (choice == 't' || choice == 'T') {
            teacherLogin.main(new String[]{});
        }
        else {
            System.out.println("Please enter a valid choice.");
            input();
        }

    }
    public static void main (String[] args) {
        input();
         validate();
    }
}

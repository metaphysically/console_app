import java.util.*;

public class studentLoggedIn {
    static Scanner input = new Scanner(System.in);
    public static void actionChooser() {
        System.out.println("NOTE: As a student, you can choose six classes for the semester. Choose accordingly.");
        System.out.println("To join a class, enter 'j'");
        System.out.println("To drop a class, enter 'd'");
        System.out.println("To get details of a class, enter 'g'");
        System.out.println("To check the classes that a specific teacher takes, enter 't'");
        System.out.println("You entered: ");
        char ch = input.next().charAt(0);

        if (ch == 'j' || ch == 'J') {

        }
        else if (ch == 'd' || ch == 'D') {

        }
        else if (ch == 'g' || ch == 'G') {

        }
        else if (ch == 't' || ch == 'T') {

        }
        else {
            System.out.println("Wrong option entered.");
            actionChooser();
        }
    }
    public static void main(String[] args) {
        actionChooser();
    }
}

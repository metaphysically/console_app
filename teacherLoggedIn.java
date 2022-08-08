import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class teacherLoggedIn {
    static Scanner input = new Scanner(System.in);
    public static int classSave(String classCode, String name, String timings) {
        int status = 0;
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into Classes (class_code, teacher, timings) values(?,?)");
            ps.setString(1, classCode);
            ps.setString(2, name);
            ps.setString(3, timings);
            status = ps.executeUpdate();
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static int classDelete(String classCode) {
        int status = 0;
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from Classes where class_code = ?");
            ps.setString(1, classCode);
            status = ps.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static void actionChooser() {
        System.out.println("For adding classes, enter 'A'");
        System.out.println("For deleting classes, enter 'D'");
        System.out.println("For editing class details, enter 'E'");
        System.out.println("For creating an attendance record, enter 'R'");
        System.out.println("For logging out, enter 'L'");


        System.out.println("You chose: ");
        char ch = input.next().charAt(0);

        if (ch == 'a' || ch == 'A') {
            addClass();
        }
        else if (ch == 'd' || ch == 'D') {
            deleteClass();
        }
        else if (ch == 'e' || ch == 'E') {

        }
        else if (ch == 'r' || ch == 'R') {

        }
        else if (ch == 'l' || ch == 'L') {
            mainScript.main(new String[]{});
        }
        else {
            System.out.println("Entered invalid option.");
            actionChooser();
        }
    }

    public static void addClass() {
        System.out.println("    Adding a class.     ");
        System.out.print("Class code: ");
        String classCode = input.next();
        String name = teacherLogin.username;
        System.out.println();
        System.out.print("Timing details: ");
        String timings = input.nextLine();

        int i = classSave(classCode, name, timings);
        if (i > 0) {
            System.out.println("Successfully added class.");
            actionChooser();
        }
        else {
            System.out.println("Unable to save data.");
            actionChooser();
        }
    }
    public static void deleteClass() {
        System.out.println("    Deleting a class.   ");
        System.out.print("Class code: ");
        String classCode = input.next();

        int i = classDelete(classCode);
        if (i > 0) {
            System.out.println("Class deleted succesfully.");
            actionChooser();
        }
        else {
            System.out.println("Unable to delete class.");
            actionChooser();
        }
    }
    public static void main (String[] args) {
        actionChooser();
    }
}

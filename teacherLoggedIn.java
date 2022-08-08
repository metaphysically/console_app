import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static boolean classExists (String classCode) {
        boolean exists = false;

        try {
            String query = "select * from Classes where class_code = ?";
            Connection con = connection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, classCode);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                exists = true;
            }
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return exists;
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
            editClass();
        }
        else if (ch == 'r' || ch == 'R') {
            createRecord();
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
    public static void editClass() {
        System.out.println("    Editing a class.    ");
        System.out.print("Class code: ");
        String classCode = input.next();

        if (classExists(classCode)) {
            updateClass(classCode);
        }
        else {
            System.out.println("Unable to find class.");
            actionChooser();
        }
    }
    public static void updateClass(String classCode) {
        System.out.println("What fields need to be edited?");
        System.out.println("For changing the name of the teacher taking the class, enter 't'");
        System.out.println("For changing the timings of the class, enter 'z'");
        System.out.print("You entered: ");

        char ch = input.next().charAt(0);

        if (ch == 't' || ch == 'T') {
            System.out.println();
            System.out.print("New Name: ");
            String name = input.next();

            int status = 0;

            try {
                String query = "update Classes set teacher = ? where class_code = ?";
                Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, name);
                pst.setString(2, classCode);
                status = pst.executeUpdate();
                con.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
            if (status > 0) {
                System.out.println("Edited the name of the teacher successfully.");
                actionChooser();
            }
            else {
                System.out.println("Unable to edit the name of the teacher.");
                actionChooser();
            }
        }
        else if (ch == 'z' || ch == 'Z') {
            System.out.println();
            System.out.print("New Timings: ");
            String timings = input.nextLine();

            int status = 0;

            try {
                String query = "update Classes set timings = ? where class_code = ?";
                Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, timings);
                pst.setString(2, classCode);
                status = pst.executeUpdate();
                con.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
            if (status > 0) {
                System.out.println("Edited the timings successfully.");
                actionChooser();
            }
            else {
                System.out.println("Unable to edit timings.");
                actionChooser();
            }
        }
        else {
            System.out.println("Option does not exist.");
            updateClass(classCode);
        }
    }
    public static void createRecord() {

    }
    public static void main (String[] args) {
        actionChooser();
    }
}

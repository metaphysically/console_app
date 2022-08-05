import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class adminLoggedIn {
    static Scanner input = new Scanner(System.in);
    public static int studentSave(String username, String password){
        int status = 0;
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into studentLogin (username, password) values(?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            status = ps.executeUpdate();
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int teacherSave(String username, String password){
        int status = 0;
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into teacherLogin (username, password) values(?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            status = ps.executeUpdate();
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int studentDelete(String username) {
        int status = 0;
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from studentLogin where username = ?");
            ps.setString(1, username);
            status = ps.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static int teacherDelete(String username) {
        int status = 0;
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from teacherLogin where username = ?");
            ps.setString(1, username);
            status = ps.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static void addStudent() {
        String username, password;
        System.out.print("Username: ");
        username = input.next();
        System.out.println();
        System.out.print("Password: ");
        password = input.next();
        System.out.println();

        int i = studentSave(username, password);
        if (i > 0) {
            System.out.println("Student data saved successfully.");
        }
        else {
            System.out.println("Unable to save data.");
        }
    }
    public static void addTeacher() {
        String username, password;
        System.out.print("Username: ");
        username = input.next();
        System.out.println();
        System.out.print("Password: ");
        password = input.next();
        System.out.println();

        int i = teacherSave(username, password);
        if (i > 0) {
            System.out.println("Teacher data saved successfully.");
        }
        else {
            System.out.println("Unable to save data.");
        }
    }
    public static void deleteStudent() {
        String username;
        System.out.print("Username: ");
        username = input.next();
        System.out.println();
        int i = studentDelete(username);

        if (i > 0) {
            System.out.println("Student data deleted successfully.");
        }
        else {
            System.out.println("Unable to delete student data.");
        }
    }
    public static void deleteTeacher() {
        String username;
        System.out.print("Username: ");
        username = input.next();
        System.out.println();
        int i = teacherDelete(username);

        if (i > 0) {
            System.out.println("Teacher data deleted successfully.");
        }
        else {
            System.out.println("Unable to delete teacher data.");
        }
    }
    public static void execute (int x) {
        if (x == 1) {
            System.out.println("Add student data.");
            addStudent();
        }
        else if (x == 2) {
            System.out.println("Add teacher data.");
            addTeacher();
        }
        else if (x == 3) {
            System.out.println("Delete student data.");
            deleteStudent();
        }
        else if (x == 4) {
            System.out.println("Delete teacher data.");
            deleteTeacher();
        }
        else {
            System.out.println("Option does not exist.");
            System.out.println("For adding a student's data into the database, enter 1");
            System.out.println("For adding a teacher's data into the database, enter 2");
            System.out.println("For deleting a student's data from the database, enter 3");
            System.out.println("For deleting a teacher's data from the database, enter 4");

            int a = input.nextInt();
            execute(a);
        }
    }
    public static void main(String[] args) {
        System.out.println("    Admin Logged in successfully.   ");
        System.out.println("For adding a student's data into the database, enter 1");
        System.out.println("For adding a teacher's data into the database, enter 2");
        System.out.println("For deleting a student's data from the database, enter 3");
        System.out.println("For deleting a teacher's data from the database, enter 4");

        System.out.println("You chose: ");
        int x = input.nextInt();
        execute(x);
    }
}
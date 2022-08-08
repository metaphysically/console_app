import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

public class studentLoggedIn {
    static Scanner input = new Scanner(System.in);
    static String studentName = studentLogin.username;
    public static int classSave(String class1, String class2, String class3, String class4, String class5, String class6) {
        int status = 0;
        try {
            Connection con = connection.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into studentClasses (studentName, class1, class2, class3, class4, class5, class6) values (?,?,?,?,?,?,?)");
            pst.setString(1, studentName);
            pst.setString(2, class1);
            pst.setString(3, class2);
            pst.setString(4, class3);
            pst.setString(5, class4);
            pst.setString(6, class5);
            pst.setString(7, class6);
            status = pst.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static void actionChooser() {
        System.out.println("NOTE: As a student, you can choose six classes for the semester. Choose accordingly.");
        System.out.println("To join the classes, enter 'j'");
        System.out.println("To drop a class, enter 'd'");
        System.out.println("To get details of a class, enter 'g'");
        System.out.println("To check the classes that a specific teacher takes, enter 't'");
        System.out.println("To log out, enter 'l'");
        System.out.println("You entered: ");
        char ch = input.next().charAt(0);

        if (ch == 'j' || ch == 'J') {
            joinClasses();
        }
        else if (ch == 'd' || ch == 'D') {
            dropClass();
        }
        else if (ch == 'g' || ch == 'G') {
            getDetails();
        }
        else if (ch == 't' || ch == 'T') {
            getClasses();
        }
        else if (ch == 'l' || ch == 'L') {
            mainScript.main(new String[]{});
        }
        else {
            System.out.println("Wrong option entered.");
            actionChooser();
        }
    }
    public static void joinClasses() {
        System.out.println("NOTE: You have to join all six classes at once. Please make your choices carefully.");
        System.out.println("Currently, the following classes are available.");
        System.out.println("ID" + "  " + "Class Code" + "  " + "Teacher" + "  " + "Timings");
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Classes");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.print(rs.getString(i) + "  ");
                }
                System.out.println();
            }
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Please make your choices here.");
        System.out.println("Please enter correct class codes. Make sure you double check the code before you move on to the next one.");
        System.out.print("Class 1");
        String class1 = input.next();
        System.out.println();
        System.out.print("Class 2: ");
        String class2 = input.next();
        System.out.println();
        System.out.print("Class 3: ");
        String class3 = input.next();
        System.out.println();
        System.out.print("Class 4: ");
        String class4 = input.next();
        System.out.println();
        System.out.print("Class 5: ");
        String class5 = input.next();
        System.out.println();
        System.out.print("Class 6: ");
        String class6 = input.next();
        System.out.println();

        int i = classSave(class1, class2, class3, class4, class5, class6);
        if (i > 0) {
            System.out.println("Classes saved successfully.");
            actionChooser();
        }
        else {
            System.out.println("Unable to save classes.");
            actionChooser();
        }
    }
    public static void dropClass() {
        System.out.println("You are about to drop a class. Please make sure you have the required permission from your coordinator.");

        System.out.println("Currently you have the following classes.");
        try {
            Connection con = connection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from studentClasses where studentName = ?");
            pst.setString(1, studentName);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Pick the class that needs to be dropped by entering the position of the class from the list.");
        System.out.println("Class number: ");
        int index = input.nextInt();
        int status = 0;
        if (index == 1) {
            try {
                Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement("update studentClasses set Class1 = NULL where studentName = ?");
                pst.setString(1, studentName);
                status = pst.executeUpdate();
                con.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
            if (status > 0) {
                System.out.println("Class dropped successfully.");
                actionChooser();
            }
            else {
                System.out.println("Failed to drop class.");
                actionChooser();
            }
        }
        else if (index == 2) {
            try {
                Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement("update studentClasses set Class2 = NULL where studentName = ?");
                pst.setString(1, studentName);
                status = pst.executeUpdate();
                con.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
            if (status > 0) {
                System.out.println("Class dropped successfully.");
                actionChooser();
            }
            else {
                System.out.println("Failed to drop class.");
                actionChooser();
            }
        }
        else if (index == 3) {
            try {
                Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement("update studentClasses set Class3 = NULL where studentName = ?");
                pst.setString(1, studentName);
                status = pst.executeUpdate();
                con.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
            if (status > 0) {
                System.out.println("Class dropped successfully.");
                actionChooser();
            }
            else {
                System.out.println("Failed to drop class.");
                actionChooser();
            }
        }
        else if (index == 4) {
            try {
                Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement("update studentClasses set Class4 = NULL where studentName = ?");
                pst.setString(1, studentName);
                status = pst.executeUpdate();
                con.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
            if (status > 0) {
                System.out.println("Class dropped successfully.");
                actionChooser();
            }
            else {
                System.out.println("Failed to drop class.");
                actionChooser();
            }
        }
        else if (index == 5) {
            try {
                Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement("update studentClasses set Class5 = NULL where studentName = ?");
                pst.setString(1, studentName);
                status = pst.executeUpdate();
                con.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
            if (status > 0) {
                System.out.println("Class dropped successfully.");
                actionChooser();
            }
            else {
                System.out.println("Failed to drop class.");
                actionChooser();
            }
        }
        else if (index == 6) {
            try {
                Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement("update studentClasses set Class7 = NULL where studentName = ?");
                pst.setString(1, studentName);
                status = pst.executeUpdate();
                con.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
            if (status > 0) {
                System.out.println("Class dropped successfully.");
                actionChooser();
            }
            else {
                System.out.println("Failed to drop class.");
                actionChooser();
            }
        }
        else {
            System.out.println("Invalid index.");
            System.out.println("Terminating class drop procedure.");
            actionChooser();
        }
    }
    public static void getDetails() {
        String classCode;
        System.out.println("Enter the class code of the class whose details you would like to receive.");
        System.out.print("Class code:");
        classCode = input.next();
        System.out.println();

        try {
            Connection con = connection.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from Classes where class_code = ?");
            pst.setString(1, classCode);
            ResultSet rs = pst.executeQuery();
            con.close();
            if (rs.isBeforeFirst()) {
                System.out.println("Class Code: " + rs.getString(1));
                System.out.println("Teacher: " + rs.getString(2));
                System.out.println("Timings: " + rs.getString(3));
                actionChooser();
            }
            else {
                System.out.println("Error in receiving data.");
                actionChooser();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void getClasses() {
        System.out.print("Teacher's name: ");
        String teacher = input.nextLine();
        System.out.println();
        System.out.println(teacher  +" takes the following classes:");

        try {
            Connection con = connection.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from Classes where teacher = ?");
            pst.setString(1, teacher);
            ResultSet rs = pst.executeQuery();
            con.close();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
                actionChooser();
            }
            else {
                System.out.println("Unable to get data.");
                actionChooser();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        actionChooser();
    }
}

package project.sportsequipmentmanagementsystem;

public class DBTestMain {
    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();

        dbHandler.connectDB();

        Student student = new Student("2315","Muhammad Wasif Ali Wasif", "Male");
        dbHandler.addStudent(student);
    }
}

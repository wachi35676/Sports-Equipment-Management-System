package project.sportsequipmentmanagementsystem;

import java.util.ArrayList;

public interface PersistenceHandler {
    void addStudent(Student student);
    void addEquipment(Equipment equipment);
    void addSportTeacher(SportsTeacher sportsTeacher);
    ArrayList<Student> getAllStudents();
    void removeStudent(String rollNumber);
}

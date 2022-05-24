package project.sportsequipmentmanagementsystem;

import java.util.ArrayList;

public interface PersistenceHandler {
    void addStudent(Student student);
    ArrayList<Student> getAllStudents();
    void removeStudent(String rollNumber);
    ArrayList<Equipment> getAllEquipments();
    void addEquipment(Equipment equipment);
    void removeEquipment(String equipmentID);
    ArrayList<SportsTeacher> getAllSportsTeacher();
    void addSportTeacher(SportsTeacher sportsTeacher);
    void removeSportsTeacher(String id);
    void processBorrowRequest(String equipmentID, String studentID, Date Date);
}

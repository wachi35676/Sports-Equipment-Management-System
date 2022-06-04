package project.sportsequipmentmanagementsystem.persistence;

import project.sportsequipmentmanagementsystem.SportsRoom.Equipment;
import project.sportsequipmentmanagementsystem.SportsRoom.EquipmentBorrowRecord;
import project.sportsequipmentmanagementsystem.SportsTeacher.SportsTeacher;
import project.sportsequipmentmanagementsystem.Student.Student;

import java.util.ArrayList;

public interface PersistenceHandler {
    void addStudent(Student student);
    ArrayList<Student> getAllStudents();
    void removeStudent(String rollNumber);
    void editStudent(Student student);
    ArrayList<Equipment> getAllEquipments();
    void addEquipment(Equipment equipment);
    void removeEquipment(String equipmentID);
    void editEquipment(Equipment equipment);
    ArrayList<SportsTeacher> getAllSportsTeacher();
    void addSportTeacher(SportsTeacher sportsTeacher);
    void removeSportsTeacher(String id);
    void editSportTeacher(SportsTeacher sportsTeacher);
    void addFine(String issueRecordID, float amount);
    ArrayList<EquipmentBorrowRecord> getAllCurrentlyBorrowedEquipmentRecords();
    void returnEquipment(EquipmentBorrowRecord equipmentBorrowRecord);
    void processBorrowRequest(EquipmentBorrowRecord equipmentBorrowRecord);
    ArrayList<EquipmentBorrowRecord> getAllBorrowedEquipmentRecords();
    EquipmentBorrowRecord getBorrowRequest(String id);
}

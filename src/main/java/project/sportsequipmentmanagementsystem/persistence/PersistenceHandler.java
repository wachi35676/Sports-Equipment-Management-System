package project.sportsequipmentmanagementsystem.persistence;

import project.sportsequipmentmanagementsystem.*;
import project.sportsequipmentmanagementsystem.SportsRoom.Defaulter;
import project.sportsequipmentmanagementsystem.SportsRoom.Equipment;
import project.sportsequipmentmanagementsystem.SportsRoom.EquipmentRequests;
import project.sportsequipmentmanagementsystem.SportsTeacher.SportsTeacher;
import project.sportsequipmentmanagementsystem.Student.Student;

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
    void  issueFine(int rollno,float amount);
    ArrayList<EquipmentRequests> checkIssuedEquipmentList();
    void EquipmentReturned(int rollNo,String date,int equipmentID,float amount);
    ArrayList<Defaulter> getDefaulters();
    void processBorrowRequest(String equipmentID, String studentID, Date Date);
}

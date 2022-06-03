package project.sportsequipmentmanagementsystem;

import project.sportsequipmentmanagementsystem.Principal.PrincipalRecord;
import project.sportsequipmentmanagementsystem.SportsRoom.*;
import project.sportsequipmentmanagementsystem.SportsTeacher.SportsTeacher;
import project.sportsequipmentmanagementsystem.SportsTeacher.SportsTeacherRecord;
import project.sportsequipmentmanagementsystem.Student.Student;
import project.sportsequipmentmanagementsystem.Student.StudentRecord;

import java.util.ArrayList;

public class EducationalInstitute {
    private StudentRecord studentRecord = new StudentRecord();
    private PrincipalRecord principalRecord;
    private SportsTeacherRecord sportsTeacherRecord = new SportsTeacherRecord();
    private SportsRoom sportsRoom = new SportsRoom();


    public EducationalInstitute(){}

    public ArrayList<Student> getAllStudentRecords(){
        return studentRecord.getAllStudentRecords();
    }

    public ArrayList<Student>  addStudent(String rollNumber, String name, String dateOfBirth){
        return studentRecord.addStudent(rollNumber, name, dateOfBirth);
    }

    public ArrayList<Student>  removeStudent(String rollNumber){
        return studentRecord.removeStudent(rollNumber);
    }

    public ArrayList<Student>  editStudent(String rollNumber, String name, String dateOfBirth){
        return studentRecord.editStudent(rollNumber, name, dateOfBirth);
    }

    public ArrayList<Equipment> getAllEquipment(){
        return sportsRoom.getAllEquipment();
    }

    public ArrayList<Equipment> addEquipment(String equipmentID, String name, String brand, String availability, String roomID){
        return sportsRoom.addEquipment(equipmentID, name, brand, availability, roomID);
    }

    public ArrayList<Equipment> removeEquipment(String equipmentID){
        return sportsRoom.removeEquipment(equipmentID);
    }

    public ArrayList<Equipment> editEquipment(String equipmentID, String name, String brand, String availability, String room){
        return sportsRoom.editEquipment(equipmentID, name, brand, availability, room);
    }

    public ArrayList<SportsTeacher> getAllSportsTeacher(){
        return sportsTeacherRecord.getAllSportsTeacher();
    }

    public ArrayList<SportsTeacher> addSportsTeacher(String id, String name, String dateOfBirth){
        return sportsTeacherRecord.addTeacher(id, name,dateOfBirth);
    }
    public ArrayList<SportsTeacher> removeSportsTeacher(String id){
        return sportsTeacherRecord.removeTeacher(id);
    }
    public ArrayList<SportsTeacher> editSportsTeacher(String id, String name, String dateOfBirth){
        return sportsTeacherRecord.editTeacher(id, name,dateOfBirth);
    }

    public void processBorrowRequest(String equipmentID, String studentID, Date dateOfIssue) {
         sportsRoom.processBorrowRequest(equipmentID,studentID,dateOfIssue);
    }

    public void issueFine(String issueRecordID, float fine){
       sportsRoom.issueFine(issueRecordID,fine);
    }

    public ArrayList<EquipmentBorrowRecord> getAllCurrentlyBorrowedEquipmentRecords(){
       return sportsRoom.getAllCurrentlyBorrowedEquipmentRecords();
    }
    public void returnEquipment(String issueRecord, String dateOfReturn){
        sportsRoom.returnEquipment(issueRecord,dateOfReturn);
    }
    public ArrayList<Defaulter> getDefaulters(){
        return sportsRoom.getDefaultersList();
    }

    public ArrayList<EquipmentBorrowRecord> getAllBorrowedEquipmentRecords(){
        return sportsRoom.getAllBorrowedEquipmentRecords();
    }
}

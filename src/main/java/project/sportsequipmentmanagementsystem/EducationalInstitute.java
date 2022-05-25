package project.sportsequipmentmanagementsystem;

import java.util.ArrayList;

public class EducationalInstitute {
    private StudentRecord studentRecord = new StudentRecord();
    private PrincipalRecord principalRecord;
    private SportsTeacherRecord sportsTeacherRecord = new SportsTeacherRecord();
    private SportsRoom sportsRoom = new SportsRoom();


    public EducationalInstitute(){}

    public EducationalInstitute(StudentRecord studentRecord, PrincipalRecord principalRecord, SportsTeacherRecord sportsTeacherRecord, SportsRoom sportsRoom) {
        this.studentRecord = studentRecord;
        this.principalRecord = principalRecord;
        this.sportsTeacherRecord = sportsTeacherRecord;
        this.sportsRoom = sportsRoom;
    }

    public ArrayList<Student> getAllStudentRecords(){
        return studentRecord.getAllStudentRecords();
    }

    public void addStudent(String rollNumber, String name, String dateOfBirth){
        studentRecord.addStudent(rollNumber, name, dateOfBirth);
    }

    public void removeStudent(String rollNumber){
        studentRecord.removeStudent(rollNumber);
    }

    public void editStudent(String rollNumber, String name, String dateOfBirth){
        studentRecord.removeStudent(rollNumber);
        studentRecord.addStudent(rollNumber, name, dateOfBirth);
    }

    public ArrayList<Equipment> getAllEquipment(){
        return sportsRoom.getAllEquipment();
    }

    public void addEquipment(String equipmentID, String name, String brand, String availability, String room){
        sportsRoom.addEquipment(equipmentID, name, brand, availability, room);
    }

    public void removeEquipment(String equipmentID){
        sportsRoom.removeEquipment(equipmentID);
    }

    public void editEquipment(String equipmentID, String name, String brand, String availability, String room){
        sportsRoom.editEquipment(equipmentID, name, brand, availability, room);
    }

    public ArrayList<SportsTeacher> getAllSportsTeacher(){
        return sportsTeacherRecord.getAllSportsTeacher();
    }

    public void addSportsTeacher(String id, String name, String dateOfBirth){
        sportsTeacherRecord.addTeacher(id, name,dateOfBirth);
    }
    public void removeSportsTeacher(String id){
        sportsTeacherRecord.removeTeacher(id);
    }

    public EquipmentBorrowRecord processBorrowRequest(String rollNumber, String [] equipmentID) {
        return sportsRoom.processBorrowRequest(rollNumber,equipmentID);
    }

    public Equipment [] checkIssuedEquipment(String rollNumber) {
        return sportsRoom.checkIssuedEquipment(rollNumber);
    }

    public Equipment [] returnIssuedEquipment(String rollNumber, String equipmentID) {
        return sportsRoom.returnIssuedEquipment(rollNumber, equipmentID);
    }

    public void IssueFine(int rollno,float amount){
       sportsTeacherRecord.issueFine(rollno,amount);
    }

    public ArrayList<EquipmentRequests> getIssuedDetails(){
       return sportsTeacherRecord.getEquipmentBorrowStatus();
    }
    public void ReturnEquipment(int rollNo, String date, int equipmentID, float amount){
        sportsTeacherRecord.equipmentReturn(rollNo,date,equipmentID,amount);
    }
    public ArrayList<StudentReturnTime> getDefaulters(){
        return sportsTeacherRecord.getDefaultersList();
    }
}

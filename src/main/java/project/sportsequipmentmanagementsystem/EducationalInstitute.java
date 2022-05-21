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

    public void addEquipment(int equipmentID, String name, String brand, String availability, String room){
        sportsRoom.addEquipment(equipmentID, name, brand, availability, room);
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

}

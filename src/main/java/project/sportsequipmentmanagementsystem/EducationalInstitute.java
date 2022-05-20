package project.sportsequipmentmanagementsystem;

import java.util.ArrayList;
import java.util.Date;

public class EducationalInstitute {
    private StudentRecord studentRecord = new StudentRecord();
    private PrincipalRecord principalRecord;
    private SportsTeacherRecord sportsTeacherRecord;
    private SportsRoom sportsRoom;

    public EducationalInstitute(){}

    public EducationalInstitute(StudentRecord studentRecord, PrincipalRecord principalRecord, SportsTeacherRecord sportsTeacherRecord, SportsRoom sportsRoom) {
        this.studentRecord = studentRecord;
        this.principalRecord = principalRecord;
        this.sportsTeacherRecord = sportsTeacherRecord;
        this.sportsRoom = sportsRoom;
    }

    public void addStudent(String rollNumber, String name, String dateOfBirth){
        studentRecord.addStudent(rollNumber, name, dateOfBirth);
    }

    //Xlayfer's functions start here ---------------------------------------------------------------------------
    //public EquipmentBorrowRecord processBorrowRequest(String rollNumber, ArrayList<Equipment> equipmentList) {
        //Create a borrowed equipment record here
    //}

    //public ArrayList<Equipment> checkIssuedEquipment(String rollNumber) {
        //Search for the issued equipment according to the student's roll number and return a list of issued equipment
        //Sports room has the issued equipment, so an object of sports room will be used to access the issued equipment
    //}
    //public ArrayList<EquipmentBorrowRecord> returnIssuedEquipment(String rollNumber, String equipmentID) {
        //EquipmentBorrowRecord tempRecord;
        //The purpose of this function is to return an equipment piece issued to a student
        //A teacher will enter the student's roll number and the ID of the equipment
        //Controller will tell the sports room to check the issued records and return the one of the given student
        //The teacher will examine the sports equipment, if damaged, they will administer a fine
        //The fine function is in the sports room class, so an object will have to be created to access that function
        //After fine is payed (if fine is applicable to the student), then the equipment issuance record will be
        //updated and the status of the equipment will be changed to "returned", the change should be reflected
        //In the DB too
        //return tempRecord;
    //}
    //Xlayfer's functions end here ------------------------------------------------------------------------------
}

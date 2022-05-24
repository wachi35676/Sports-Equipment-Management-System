package project.sportsequipmentmanagementsystem;

import java.util.ArrayList;

public class SportsRoom {
    private EquipmentRecord equipmentRecord = new EquipmentRecord();
    private EquipmentBorrowRecord equipmentBorrowRecord;
    private SportsTeacher sportsTeacher;

    public void addEquipment(String equipmentID, String name, String brand, String availability, String room){
        equipmentRecord.addEquipment(equipmentID, name, brand, availability, room);
    }

    public void removeEquipment(String equipmentID){
        equipmentRecord.removeEquipment(equipmentID);
    }

    public void editEquipment(String equipmentID, String name, String brand, String availability, String room){
        equipmentRecord.removeEquipment(equipmentID);
        equipmentRecord.addEquipment(equipmentID, name, brand, availability, room);
    }

    public ArrayList<Equipment> getAllEquipment(){
        return equipmentRecord.getAllEquipment();
    }

    public void processBorrowRequest(String equipmentID, String studentID, Date Date) {
        equipmentBorrowRecord.processBorrowRequest(equipmentID,studentID,Date);
    }


    public Equipment [] checkIssuedEquipment(String rollNumber) {
//        Search for the issued equipment according to the student's roll number and return a list of issued equipment
//        Sports room has the issued equipment, so an object of sports room will be used to access the issued equipment
        return null;
    }

    public Equipment [] returnIssuedEquipment(String rollNumber, String equipmentID) {
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
        return null;
    }
}

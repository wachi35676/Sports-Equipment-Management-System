package project.sportsequipmentmanagementsystem.SportsRoom;

import project.sportsequipmentmanagementsystem.Date;
import project.sportsequipmentmanagementsystem.SportsTeacher.SportsTeacher;
import project.sportsequipmentmanagementsystem.persistence.PersistenceFactory;
import project.sportsequipmentmanagementsystem.persistence.PersistenceHandler;

import java.util.ArrayList;

public class SportsRoom {
    private Rack rack = new Rack();
    private EquipmentBorrowRecord equipmentBorrowRecord;
    private SportsTeacher sportsTeacher;

    public ArrayList<Equipment> addEquipment(String equipmentID, String name, String brand, String availability, String roomID){
        return rack.addEquipment(equipmentID, name, brand, availability, roomID);
    }

    public ArrayList<Equipment> removeEquipment(String equipmentID){
        return rack.removeEquipment(equipmentID);
    }

    public ArrayList<Equipment> editEquipment(String equipmentID, String name, String brand, String availability, String room){
        return rack.editEquipment(equipmentID, name, brand, availability, room);
    }

    public ArrayList<Equipment> getAllEquipment(){
        return rack.getAllEquipment();
    }

    public void processBorrowRequest(String equipmentID, String studentID, Date dateOfIssue) {
        EquipmentBorrowRecord equipmentBorrowRecordToAdd = new EquipmentBorrowRecord(equipmentID, studentID, dateOfIssue);

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();
        persistenceHandler.processBorrowRequest(equipmentBorrowRecordToAdd);
    }

    public ArrayList<EquipmentBorrowRecord> getAllCurrentlyBorrowedEquipmentRecords(){

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();
        return persistenceHandler.getAllCurrentlyBorrowedEquipmentRecords();
    }
    public ArrayList<Defaulter> getDefaultersList(){
        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();
        return persistenceHandler.getDefaulters();
    }

    public void returnEquipment(int issueRecord, String dateOfReturn){

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();
        persistenceHandler.returnEquipment(issueRecord,dateOfReturn);
    }

    public void issueFine(int issueRecordId,float fine){

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();
        persistenceHandler.issueFine(issueRecordId,fine);
    }

    public ArrayList<EquipmentBorrowRecord> getAllBorrowedEquipmentRecords(){
        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();
        return persistenceHandler.getAllBorrowedEquipmentRecords();
    }
}

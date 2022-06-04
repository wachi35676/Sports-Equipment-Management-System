package project.sportsequipmentmanagementsystem.SportsRoom;

import project.sportsequipmentmanagementsystem.Date;
import project.sportsequipmentmanagementsystem.SportsTeacher.SportsTeacher;
import project.sportsequipmentmanagementsystem.persistence.PersistenceFactory;
import project.sportsequipmentmanagementsystem.persistence.PersistenceHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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

    public float returnEquipment(String issueRecord, String dateOfReturn){
        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();

        EquipmentBorrowRecord equipmentBorrowRecord1 = persistenceHandler.getBorrowRequest(issueRecord);

        equipmentBorrowRecord1.setDateOfReturn(new Date(dateOfReturn));
        float fine = calculateFine(equipmentBorrowRecord1);

        equipmentBorrowRecord1.setFine(fine);
        equipmentBorrowRecord1.setBorrowRecordID(issueRecord);

        persistenceHandler.returnEquipment(equipmentBorrowRecord1);

        return fine;
    }

    private float calculateFine(EquipmentBorrowRecord equipmentBorrowRecord) {
        float fine;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);

        Date issueDate = equipmentBorrowRecord.getDateOfIssue();
        Date returnDate = equipmentBorrowRecord.getDateOfReturn();

        long diff;
        try {
            diff = sdf.parse(returnDate.convert()).getTime() - sdf.parse(issueDate.convert()).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        TimeUnit time = TimeUnit.DAYS;
        double difference = time.convert(diff, TimeUnit.MILLISECONDS);

        fine = (float) (difference * 100);

        return fine;
    }

    public void addFine(String issueRecordId, float fine){

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();
        persistenceHandler.addFine(issueRecordId,fine);
    }

    public ArrayList<EquipmentBorrowRecord> getAllBorrowedEquipmentRecords(){
        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();
        return persistenceHandler.getAllBorrowedEquipmentRecords();
    }
}

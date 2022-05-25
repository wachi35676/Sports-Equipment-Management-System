package project.sportsequipmentmanagementsystem;

public class EquipmentBorrowRecord {
    public void processBorrowRequest(String equipmentID, String studentID, Date Date) {
        new PersistenceFactory().getConnection().processBorrowRequest(equipmentID, studentID, Date);
    }
}

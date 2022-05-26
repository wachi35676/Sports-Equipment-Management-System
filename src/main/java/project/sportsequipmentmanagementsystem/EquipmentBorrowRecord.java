package project.sportsequipmentmanagementsystem;

public class EquipmentBorrowRecord {
    public void processBorrowRequest(String equipmentID, String studentID, Date Date) {
        PersistenceFactory.getConnection().processBorrowRequest(equipmentID, studentID, Date);
    }
}

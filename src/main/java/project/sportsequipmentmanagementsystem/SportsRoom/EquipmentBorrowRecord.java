package project.sportsequipmentmanagementsystem.SportsRoom;

import project.sportsequipmentmanagementsystem.Date;
import project.sportsequipmentmanagementsystem.persistence.PersistenceFactory;

public class EquipmentBorrowRecord {
    public void processBorrowRequest(String equipmentID, String studentID, Date Date) {
        PersistenceFactory.getConnection().processBorrowRequest(equipmentID, studentID, Date);
    }
}

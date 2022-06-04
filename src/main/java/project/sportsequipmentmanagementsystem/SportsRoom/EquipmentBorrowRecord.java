package project.sportsequipmentmanagementsystem.SportsRoom;

import project.sportsequipmentmanagementsystem.Date;
import project.sportsequipmentmanagementsystem.persistence.PersistenceFactory;

public class EquipmentBorrowRecord {
    public String borrowRecordID;

    public String equipmentID;
    public String studentID;
    public Date dateOfIssue;
    public Date dateOfReturn;
    public Float fine;


    public EquipmentBorrowRecord(){}

    public EquipmentBorrowRecord(String borrowRecordID, String equipmentID, String studentID, Date dateOfIssue, Date dateOfReturn, Float fine) {
        this.borrowRecordID = borrowRecordID;
        this.equipmentID = equipmentID;
        this.studentID = studentID;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
        this.fine = fine;
    }

    public EquipmentBorrowRecord( String equipmentID, String studentID, Date dateOfIssue){
        this.equipmentID = equipmentID;
        this.studentID = studentID;
        this.dateOfIssue = dateOfIssue;
    }

    public EquipmentBorrowRecord(String issuanceRecordID, String equipmentID, String studentID, Date issueDate) {
        this.borrowRecordID = issuanceRecordID;
        this.equipmentID = equipmentID;
        this.studentID = studentID;
        this.dateOfIssue = issueDate;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Float getFine() {
        return fine;
    }

    public void setFine(Float fine) {
        this.fine = fine;
    }

    public String getBorrowRecordID() {
        return borrowRecordID;
    }

    public void setBorrowRecordID(String borrowRecordID) {
        this.borrowRecordID = borrowRecordID;
    }

    @Override
    public String toString() {
        return "EquipmentBorrowRecord{" +
                "borrowRecordID='" + borrowRecordID + '\'' +
                ", equipmentID='" + equipmentID + '\'' +
                ", studentID='" + studentID + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                ", dateOfReturn=" + dateOfReturn +
                ", fine=" + fine +
                '}';
    }
}

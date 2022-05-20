package project.sportsequipmentmanagementsystem;

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

    public void addStudent(String rollNumber, String name, String dateOfBirth){
        studentRecord.addStudent(rollNumber, name, dateOfBirth);
    }

    public void addEquipment(int equipmentID, String name, String brand, String availability, String room){
        sportsRoom.addEquipment(equipmentID, name, brand, availability, room);
    }

    public void addSportsTeacher(String id, String name, String dateOfBirth){
        sportsTeacherRecord.addTeacher(id, name,dateOfBirth);
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

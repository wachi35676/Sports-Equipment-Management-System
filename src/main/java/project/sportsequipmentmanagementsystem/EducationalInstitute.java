package project.sportsequipmentmanagementsystem;

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
}

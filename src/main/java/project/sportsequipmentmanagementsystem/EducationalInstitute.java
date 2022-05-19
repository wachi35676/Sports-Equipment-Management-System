package project.sportsequipmentmanagementsystem;

public class EducationalInstitute {
    private StudentRecord studentRecord;
    private PrincipalRecord principalRecord;
    private SportsTeacherRecord sportsTeacherRecord;
    private SportsRoom sportsRoom;

    EducationalInstitute(){}

    public EducationalInstitute(StudentRecord studentRecord, PrincipalRecord principalRecord, SportsTeacherRecord sportsTeacherRecord, SportsRoom sportsRoom) {
        this.studentRecord = studentRecord;
        this.principalRecord = principalRecord;
        this.sportsTeacherRecord = sportsTeacherRecord;
        this.sportsRoom = sportsRoom;
    }
}

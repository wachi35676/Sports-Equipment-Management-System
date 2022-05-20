package project.sportsequipmentmanagementsystem;

public class SportsTeacherRecord {
    private SportsTeacher sportsTeacher;
    public void addTeacher(String rollNumber, String name, String dateOfBirth){
        dateOfBirth = dateOfBirth.replaceAll("/","");
        dateOfBirth = dateOfBirth.replaceAll("-","");
        Date date = new Date(dateOfBirth);
        SportsTeacher sportsTeacherToAdd = new SportsTeacher(rollNumber, name, date);

        PersistenceFactory persistenceFactory = new PersistenceFactory();
        PersistenceHandler persistenceHandler = persistenceFactory.getConnection();

        persistenceHandler.addSportTeacher(sportsTeacherToAdd);
    }
}

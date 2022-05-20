package project.sportsequipmentmanagementsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentRecord {

    public void addStudent(String rollNumber, String name, String dateOfBirth){
        dateOfBirth = dateOfBirth.replaceAll("/","");
        dateOfBirth = dateOfBirth.replaceAll("-","");
        Date date = new Date(dateOfBirth);
        Student studentToAdd = new Student(rollNumber, name, date);

        PersistenceFactory persistenceFactory = new PersistenceFactory();
        PersistenceHandler persistenceHandler = persistenceFactory.getConnection();

        persistenceHandler.addStudent(studentToAdd);
    }
}

package project.sportsequipmentmanagementsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

    public void removeStudent(String rollNumber){
        PersistenceFactory persistenceFactory = new PersistenceFactory();
        PersistenceHandler persistenceHandler = persistenceFactory.getConnection();

        persistenceHandler.removeStudent(rollNumber);
    }

    public ArrayList<Student> getAllStudentRecords(){
        return new PersistenceFactory().getConnection().getAllStudents(); //bad practice i know but i was to lazy
    }
}

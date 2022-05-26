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

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();

        persistenceHandler.addStudent(studentToAdd);
    }

    public void removeStudent(String rollNumber){

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();

        persistenceHandler.removeStudent(rollNumber);
    }

    public ArrayList<Student> getAllStudentRecords(){
        return PersistenceFactory.getConnection().getAllStudents(); //bad practice i know but i was to lazy
    }
}

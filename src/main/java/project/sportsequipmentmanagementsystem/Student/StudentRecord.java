package project.sportsequipmentmanagementsystem.Student;

import project.sportsequipmentmanagementsystem.Date;
import project.sportsequipmentmanagementsystem.persistence.PersistenceFactory;
import project.sportsequipmentmanagementsystem.persistence.PersistenceHandler;

import java.util.ArrayList;

public class StudentRecord {

    public ArrayList<Student> addStudent(String rollNumber, String name, String dateOfBirth){
        dateOfBirth = dateOfBirth.replaceAll("/","");
        dateOfBirth = dateOfBirth.replaceAll("-","");
        Date date = new Date(dateOfBirth);
        Student studentToAdd = new Student(rollNumber, name, date);

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();

        persistenceHandler.addStudent(studentToAdd);

        return getAllStudentRecords();
    }

    public ArrayList<Student>  removeStudent(String rollNumber){
        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();

        persistenceHandler.removeStudent(rollNumber);

        return getAllStudentRecords();
    }

    public ArrayList<Student>  editStudent(String rollNumber, String name, String dateOfBirth){
        dateOfBirth = dateOfBirth.replaceAll("/","");
        dateOfBirth = dateOfBirth.replaceAll("-","");
        Date date = new Date(dateOfBirth);
        Student studentToEdit = new Student(rollNumber, name, date);

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();

        persistenceHandler.editStudent(studentToEdit);

        return getAllStudentRecords();
    }

    public ArrayList<Student> getAllStudentRecords(){
        return PersistenceFactory.getConnection().getAllStudents();
    }
}

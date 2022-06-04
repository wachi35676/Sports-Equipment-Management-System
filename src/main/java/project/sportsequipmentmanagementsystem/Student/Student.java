package project.sportsequipmentmanagementsystem.Student;

import project.sportsequipmentmanagementsystem.Date;
import project.sportsequipmentmanagementsystem.persistence.PersistenceFactory;
import project.sportsequipmentmanagementsystem.persistence.PersistenceHandler;

import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private Date date;

    public Student (){}

    public Student(String id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

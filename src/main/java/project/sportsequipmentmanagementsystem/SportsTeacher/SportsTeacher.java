package project.sportsequipmentmanagementsystem.SportsTeacher;

import project.sportsequipmentmanagementsystem.Date;
import project.sportsequipmentmanagementsystem.persistence.PersistenceFactory;
import project.sportsequipmentmanagementsystem.persistence.PersistenceHandler;

import java.util.ArrayList;

public class SportsTeacher {
    private String id;
    private String name;
    private Date dateOfBirth;

    public SportsTeacher(){}

    public SportsTeacher(String id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<SportsTeacher> addTeacher(String id, String name, String dateOfBirth){
        dateOfBirth = dateOfBirth.replaceAll("/","");
        dateOfBirth = dateOfBirth.replaceAll("-","");
        Date date = new Date(dateOfBirth);
        SportsTeacher sportsTeacherToAdd = new SportsTeacher(id, name, date);

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();

        persistenceHandler.addSportTeacher(sportsTeacherToAdd);

        return getAllSportsTeacher();
    }

    public ArrayList<SportsTeacher> editTeacher(String id, String name, String dateOfBirth){
        dateOfBirth = dateOfBirth.replaceAll("/","");
        dateOfBirth = dateOfBirth.replaceAll("-","");
        Date date = new Date(dateOfBirth);
        SportsTeacher sportsTeacherToAdd = new SportsTeacher(id, name, date);

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();

        persistenceHandler.editSportTeacher(sportsTeacherToAdd);

        return getAllSportsTeacher();
    }

    public ArrayList<SportsTeacher> removeTeacher(String id){
        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();

        persistenceHandler.removeSportsTeacher(id);

        return getAllSportsTeacher();
    }

    public ArrayList<SportsTeacher> getAllSportsTeacher(){

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();

        return persistenceHandler.getAllSportsTeacher();
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    void IssueFine(){



    }
}

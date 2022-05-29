package project.sportsequipmentmanagementsystem.SportsTeacher;

import project.sportsequipmentmanagementsystem.Date;
import project.sportsequipmentmanagementsystem.SportsRoom.EquipmentRequests;
import project.sportsequipmentmanagementsystem.persistence.PersistenceFactory;
import project.sportsequipmentmanagementsystem.persistence.PersistenceHandler;

import java.util.ArrayList;

public class SportsTeacherRecord {
    private SportsTeacher sportsTeacher;
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
    public void issueFine(int rollNo,float fineAmount){

        PersistenceHandler persistenceHandler = PersistenceFactory.getConnection();
        persistenceHandler.issueFine(rollNo,fineAmount);
    }
}

package project.sportsequipmentmanagementsystem;

import java.util.ArrayList;

public class SportsTeacherRecord {
    private SportsTeacher sportsTeacher;
    public void addTeacher(String id, String name, String dateOfBirth){
        dateOfBirth = dateOfBirth.replaceAll("/","");
        dateOfBirth = dateOfBirth.replaceAll("-","");
        Date date = new Date(dateOfBirth);
        SportsTeacher sportsTeacherToAdd = new SportsTeacher(id, name, date);

        PersistenceFactory persistenceFactory = new PersistenceFactory();
        PersistenceHandler persistenceHandler = persistenceFactory.getConnection();

        persistenceHandler.addSportTeacher(sportsTeacherToAdd);
    }

    public void removeTeacher(String id){
        PersistenceFactory persistenceFactory = new PersistenceFactory();
        PersistenceHandler persistenceHandler = persistenceFactory.getConnection();

        persistenceHandler.removeSportsTeacher(id);
    }

    public ArrayList<SportsTeacher> getAllSportsTeacher(){
        PersistenceFactory persistenceFactory = new PersistenceFactory();
        PersistenceHandler persistenceHandler = persistenceFactory.getConnection();

        return persistenceHandler.getAllSportsTeacher();
    }
    public void issueFine(int rollNo,float fineAmount){
        PersistenceFactory persistenceFactory = new PersistenceFactory();
        PersistenceHandler persistenceHandler = persistenceFactory.getConnection();
        persistenceHandler.issueFine(rollNo,fineAmount);
    }
    public ArrayList<EquipmentRequests> getEquipmentBorrowStatus(){
        PersistenceFactory persistenceFactory = new PersistenceFactory();
        PersistenceHandler persistenceHandler = persistenceFactory.getConnection();
        return persistenceHandler.checkIssuedEquipmentList();
    }
    public void equipmentReturn(int rollNo, String date, int equipmentID, float amount){
        PersistenceFactory persistenceFactory = new PersistenceFactory();
        PersistenceHandler persistenceHandler = persistenceFactory.getConnection();
        persistenceHandler.EquipmentReturned(rollNo,date,equipmentID,amount);
    }
    public ArrayList<Defaulter> getDefaultersList(){
        PersistenceFactory persistenceFactory = new PersistenceFactory();
        PersistenceHandler persistenceHandler = persistenceFactory.getConnection();
        return persistenceHandler.getDefaulters();
    }
}

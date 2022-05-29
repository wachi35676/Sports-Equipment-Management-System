package project.sportsequipmentmanagementsystem.SportsRoom;

import project.sportsequipmentmanagementsystem.SportsRoom.Equipment;
import project.sportsequipmentmanagementsystem.persistence.PersistenceFactory;

import java.util.ArrayList;

public class Rack {
    public ArrayList<Equipment> addEquipment(String equipmentID, String name, String brand, String availability, String roomID){
        Equipment equipmentToAdd = new Equipment(equipmentID, name, brand, availability, roomID);
        PersistenceFactory.getConnection().addEquipment(equipmentToAdd);

        return PersistenceFactory.getConnection().getAllEquipments();
    }

    public ArrayList<Equipment> removeEquipment(String equipmentID){
        PersistenceFactory.getConnection().removeEquipment(equipmentID);

        return PersistenceFactory.getConnection().getAllEquipments();
    }

    public ArrayList<Equipment> editEquipment(String equipmentID, String name, String brand, String availability, String room){
        Equipment equipmentToEdit = new Equipment(equipmentID, name, brand, availability, room);
        PersistenceFactory.getConnection().editEquipment(equipmentToEdit);

        return PersistenceFactory.getConnection().getAllEquipments();
    }

    public ArrayList<Equipment> getAllEquipment(){
        return PersistenceFactory.getConnection().getAllEquipments();
    }

}

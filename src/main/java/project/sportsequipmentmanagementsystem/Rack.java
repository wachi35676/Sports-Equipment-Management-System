package project.sportsequipmentmanagementsystem;

import java.util.ArrayList;

public class Rack {
    public void addEquipment(String equipmentID, String name, String brand, String availability, String room){
        Equipment equipmentToAdd = new Equipment(equipmentID, name, brand, availability, room);
        PersistenceFactory.getConnection().addEquipment(equipmentToAdd);
    }

    public void removeEquipment(String equipmentID){
        PersistenceFactory.getConnection().removeEquipment(equipmentID);
    }

    public ArrayList<Equipment> getAllEquipment(){
        return PersistenceFactory.getConnection().getAllEquipments();
    }

}

package project.sportsequipmentmanagementsystem;

public class EquipmentRecord {
    public void addEquipment(int equipmentID, String name, String brand, String availability, String room){
        Equipment equipmentToAdd = new Equipment(equipmentID, name, brand, availability, room);
        new PersistenceFactory().getConnection().addEquipment(equipmentToAdd);
    }
}

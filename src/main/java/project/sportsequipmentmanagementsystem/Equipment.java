package project.sportsequipmentmanagementsystem;

public class Equipment {
    private int equipmentID;
    private String name;
    private String brand;
    private String availability;
    private String room;

    public Equipment(){}

    public Equipment(int equipmentID, String name, String brand, String availability, String room) {
        this.equipmentID = equipmentID;
        this.name = name;
        this.brand = brand;
        this.availability = availability;
        this.room = room;
    }

    public Integer getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}

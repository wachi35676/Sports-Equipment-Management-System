package project.sportsequipmentmanagementsystem;

public class StudentReturnTime {

   String Studentid;
   String EquipmentName;
   String EquipmentID;
   String timeOFreturn;

   public StudentReturnTime(String studentid,String EquipmentName,String equipmentID,String timeOFreturn){
       this.Studentid=Studentid;
       this.EquipmentID=equipmentID;
       this.EquipmentName=EquipmentName;
       this.timeOFreturn=timeOFreturn;
   }

    public void setEquipmentID(String equipmentID) {
        EquipmentID = equipmentID;
    }

    public void setEquipmentName(String equipmentName) {
        EquipmentName = equipmentName;
    }

    public void setStudentid(String studentid) {
        Studentid = studentid;
    }

    public void setTimeOFreturn(String timeOFreturn) {
        this.timeOFreturn = timeOFreturn;
    }

    public String getEquipmentID() {
        return EquipmentID;
    }

    public String getEquipmentName() {
        return EquipmentName;
    }

    public String getTimeOFreturn() {
        return timeOFreturn;
    }

    public String getStudentid() {
        return Studentid;
    }
}

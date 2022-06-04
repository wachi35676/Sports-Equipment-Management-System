package project.sportsequipmentmanagementsystem.persistence;

import project.sportsequipmentmanagementsystem.SportsRoom.Equipment;
import project.sportsequipmentmanagementsystem.SportsRoom.EquipmentBorrowRecord;
import project.sportsequipmentmanagementsystem.SportsTeacher.SportsTeacher;
import project.sportsequipmentmanagementsystem.Student.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class DBHandler implements PersistenceHandler{
    private Connection connection = null;

    public void connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/semsdb", "root", "");
            if (connection == null){
                System.out.println("DB Connection Failed");
            }
            else{
                System.out.println("DB Connection Successful");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void addStudent(Student student){
        try{
            String sql = "insert into Student (Student_ID, Name, Date_Of_Birth) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getDate().toString());

            preparedStatement.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    public void addEquipment(Equipment equipment){
        try{
            String sql = "insert into equipment (Equipment_ID, Name, Brand_Name, Availability, Room_ID) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, equipment.getEquipmentID().toString());
            preparedStatement.setString(2, equipment.getName());
            preparedStatement.setString(3, equipment.getBrand());
            preparedStatement.setString(4, equipment.getAvailability());
            preparedStatement.setString(5, equipment.getRoom());

            preparedStatement.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void removeEquipment(String equipmentID) {
        try{
            String sql = "delete from equipment where Equipment_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,equipmentID);

            preparedStatement.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void editEquipment(Equipment equipment) {
        removeStudent(equipment.getEquipmentID());
        addEquipment(equipment);
    }

    @Override
    public ArrayList<SportsTeacher> getAllSportsTeacher() {
        ArrayList<SportsTeacher> sportsTeachers = new ArrayList<>();

        try{
            String sql = "select * from sports_teacher";
            Statement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                //ugly code and bad practice i know plz spare me
                sportsTeachers.add(new SportsTeacher (resultSet.getString("SportsTeacherID"), resultSet.getString("Name"), new project.sportsequipmentmanagementsystem.Date(resultSet.getString("Date_Of_Birth"))));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return sportsTeachers;
    }

    public void addSportTeacher(SportsTeacher sportsTeacher){
        try{
            String sql = "insert into sports_teacher (SportsTeacherID, Name, Date_Of_Birth) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, sportsTeacher.getId());
            preparedStatement.setString(2, sportsTeacher.getName());
            preparedStatement.setString(3, sportsTeacher.getDateOfBirth().toString());

            preparedStatement.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void removeSportsTeacher(String id) {
        try{
            String sql = "delete from sports_teacher where SportsTeacherID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,id);

            preparedStatement.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void editSportTeacher(SportsTeacher sportsTeacher) {
        removeSportsTeacher(sportsTeacher.getId());
        addSportTeacher(sportsTeacher);
    }

    @Override
    public void addFine(String issueRecordID, float fine) {
        try {
            String sql = "update issuance_record set Fine=? where Issuance_Record_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, fine);
            preparedStatement.setString(2, issueRecordID);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public void processBorrowRequest(EquipmentBorrowRecord equipmentBorrowRecord) {
        try{
            String sql = "insert into issuance_record (Equipment_ID, Student_ID, Date_Issued) values (?,?,?)";



            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, equipmentBorrowRecord.getEquipmentID());
            preparedStatement.setString(2, equipmentBorrowRecord.getStudentID());
            preparedStatement.setString(3, equipmentBorrowRecord.getDateOfIssue().toString());
            preparedStatement.execute();


            String sql2 ="update equipment  set Availability='Unavailable' where Equipment_ID=?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setString(1,equipmentBorrowRecord.getEquipmentID());
            preparedStatement2.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<EquipmentBorrowRecord> getAllBorrowedEquipmentRecords() {
        ArrayList<EquipmentBorrowRecord> equipmentBorrowRecords = new ArrayList<>();
        try{
            String sql = "SELECT * FROM issuance_record";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                String issuanceRecordID = resultSet.getString("Issuance_Record_ID");
                String equipmentID = resultSet.getString("Equipment_ID");
                String studentID = resultSet.getString("Student_ID");
                project.sportsequipmentmanagementsystem.Date issueDate;
                try {
                    issueDate = new project.sportsequipmentmanagementsystem.Date(resultSet.getString("Date_Issued"));
                }
                catch (Exception e){
                    issueDate = new project.sportsequipmentmanagementsystem.Date("000000");
                }

                project.sportsequipmentmanagementsystem.Date returnDate;
                try {
                    returnDate = new project.sportsequipmentmanagementsystem.Date(resultSet.getString("Date_Returned"));
                }
                catch (Exception e){
                    returnDate = new project.sportsequipmentmanagementsystem.Date("000000");;
                }

                float fine;
                try {
                    fine = Float.parseFloat(resultSet.getString("Fine"));
                }
                catch(Exception e){
                    fine = 0;
                }

                equipmentBorrowRecords.add(new EquipmentBorrowRecord (issuanceRecordID, equipmentID,studentID, issueDate, returnDate, fine));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return equipmentBorrowRecords;
    }

    @Override
    public EquipmentBorrowRecord getBorrowRequest(String id) {

        ArrayList<EquipmentBorrowRecord> equipmentBorrowRecords = getAllCurrentlyBorrowedEquipmentRecords();

        for (int i = 0; i < equipmentBorrowRecords.size(); i++) {

            System.out.println(id + " " + equipmentBorrowRecords.get(i).getBorrowRecordID());

            if(Objects.equals(id, equipmentBorrowRecords.get(i).getBorrowRecordID())){
                return equipmentBorrowRecords.get(i);
            }
        }

        return new EquipmentBorrowRecord();
    }

    @Override
    public ArrayList<EquipmentBorrowRecord> getAllCurrentlyBorrowedEquipmentRecords() {
        ArrayList<EquipmentBorrowRecord> equipmentBorrowRecords = new ArrayList<>();
        try{
            String sql = "SELECT * FROM issuance_record where Date_Returned is null";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);


            while(resultSet.next()){

                String issuanceRecordID = resultSet.getString("Issuance_Record_ID");
                String equipmentID = resultSet.getString("Equipment_ID");
                String studentID = resultSet.getString("Student_ID");
                project.sportsequipmentmanagementsystem.Date issueDate;
                try {
                    issueDate = new project.sportsequipmentmanagementsystem.Date(resultSet.getString("Date_Issued"));
                }
                catch (Exception e){
                    issueDate = new project.sportsequipmentmanagementsystem.Date("000000");
                }

//                project.sportsequipmentmanagementsystem.Date returnDate;
//                try {
//                    returnDate = new project.sportsequipmentmanagementsystem.Date(resultSet.getString("Date_Returned"));
//                }
//                catch (Exception e){
//                    returnDate = new project.sportsequipmentmanagementsystem.Date("000000");;
//                }
//
//                float fine;
//                try {
//                    fine = Float.parseFloat(resultSet.getString("Fine"));
//                }
//                catch(Exception e){
//                    fine = 0;
//                }

                equipmentBorrowRecords.add(new EquipmentBorrowRecord (issuanceRecordID, equipmentID,studentID, issueDate));
            }

        }catch (Exception e){

        }
        return equipmentBorrowRecords;
    }

    @Override
    public void returnEquipment(EquipmentBorrowRecord equipmentBorrowRecord) {
        try{
            String sql1 = "update issuance_record set Date_Returned=?, Fine = ? where Issuance_Record_ID=?";
            String sql2 ="update equipment INNER join issuance_record on equipment.Equipment_ID = issuance_record.Equipment_ID set Availability='Available' where Issuance_Record_ID=?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1,equipmentBorrowRecord.getDateOfReturn().toString());
            preparedStatement1.setString(2,equipmentBorrowRecord.getFine().toString());
            preparedStatement1.setInt(3,Integer.parseInt(equipmentBorrowRecord.getBorrowRecordID()));
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setInt(1,Integer.parseInt(equipmentBorrowRecord.getBorrowRecordID()));
            preparedStatement1.execute();
            preparedStatement2.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }


    @Override
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try{
            String sql = "select * from student";
            Statement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                //ugly code and bad practice i know plz spare me
                students.add(new Student (resultSet.getString("Student_ID"), resultSet.getString("Name"), new project.sportsequipmentmanagementsystem.Date(resultSet.getString("Date_Of_Birth"))));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return students;
    }

    @Override
    public void removeStudent(String rollNumber) {
        try{
            String sql = "delete from student where Student_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,rollNumber);

            preparedStatement.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void editStudent(Student student) {
        removeStudent(student.getId());
        addStudent(student);
    }

    @Override
    public ArrayList<Equipment> getAllEquipments() {
        ArrayList<Equipment> equipments = new ArrayList<>();

        try{
            String sql = "select * from equipment";
            Statement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                //ugly code and bad practice i know plz spare me
                equipments.add(new Equipment (resultSet.getString("Equipment_ID"), resultSet.getString("Name"), resultSet.getString("Brand_Name"), resultSet.getString("Availability"), resultSet.getString("Room_ID")));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return equipments;
    }


}
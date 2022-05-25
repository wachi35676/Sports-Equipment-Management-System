package project.sportsequipmentmanagementsystem;

import java.sql.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
    public void issueFine(int rollno, float amount) {
        try{
            String sql = "update issuance_record set Fine=? where Student_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1,amount);
            preparedStatement.setInt(2,rollno);
            preparedStatement.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<EquipmentRequests> checkIssuedEquipmentList() {
        ArrayList<EquipmentRequests> records = new ArrayList<>();
        try{
            String sql = "SELECT issuance_record.Student_ID,equipment.Name,issuance_record.Date_Issued,issuance_record.Equipment_ID FROM issuance_record INNER JOIN equipment ON equipment.Equipment_ID=issuance_record.Equipment_ID;";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                records.add(new EquipmentRequests (resultSet.getString("Student_ID"), resultSet.getString("Name"), new project.sportsequipmentmanagementsystem.Date(resultSet.getString("Date_Issued")), resultSet.getString("Equipment_ID")));
            }

        }catch (Exception e){

        }
        return records;
    }

    @Override
    public void EquipmentReturned(int rollNo, String date, int equipmentID, float amount) {
        try{
            String sql1 = "update issuance_record set Date_Returned=?,Fine=? where Student_ID=?";
            String sql2 ="update equipment set Availability='Available' where Equipment_ID=?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1,date);
            preparedStatement1.setFloat(2,amount);
            preparedStatement1.setInt(3,rollNo);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setInt(1,equipmentID);
            preparedStatement1.execute();
            preparedStatement2.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<StudentReturnTime> getDefaulters() {
        ArrayList<StudentReturnTime> defaulters = new ArrayList<>();
        try{
            String sql = "SELECT issuance_record.Student_ID,equipment.Name,issuance_record.Equipment_ID,issuance_record.Date_Issued,issuance_record.Date_Returned FROM issuance_record INNER JOIN equipment ON equipment.Equipment_ID=issuance_record.Equipment_ID";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);

            while(resultSet.next()){
                String StudentID = resultSet.getString("Student_ID");
                String EquipmentName= resultSet.getString("Name");
                String equipmentID = resultSet.getString("Equipment_ID");
                String DateIssued =   resultSet.getString("Date_Issued");
                String DateReturned =  resultSet.getString("Date_Returned");
                project.sportsequipmentmanagementsystem.Date Issueddate = new project.sportsequipmentmanagementsystem.Date(DateIssued);
                project.sportsequipmentmanagementsystem.Date ReturnDate = new project.sportsequipmentmanagementsystem.Date(DateReturned);
                Date issuedDate = sdf.parse(Issueddate.convert());
                Date returndatee = sdf.parse( ReturnDate.convert());
                long diff = returndatee.getTime() - issuedDate.getTime();
                TimeUnit time = TimeUnit.DAYS;
                double diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
                System.out.println("The difference in days is : "+diffrence);
                String timePassed = Double.toString(diffrence);
                defaulters.add(new StudentReturnTime(StudentID,EquipmentName,equipmentID,timePassed));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return defaulters;
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
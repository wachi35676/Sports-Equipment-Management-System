package project.sportsequipmentmanagementsystem;

import java.sql.*;
import java.util.ArrayList;

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
            String sql = "insert into Equipment (Equipment_ID, Name, Brand_Name, Availability, Room_ID) values (?,?,?,?,?)";
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
                sportsTeachers.add(new SportsTeacher (resultSet.getString("SportsTeacherID"), resultSet.getString("Name"), new Date (resultSet.getString("Date_Of_Birth"))));
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
    public void processBorrowRequest(String equipmentID, String studentID, Date Date) {
        try{
            String sql = "insert into issuance_record (Equipment_ID, Student_ID, Date_Issued) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, equipmentID);
            preparedStatement.setString(2, studentID);
            preparedStatement.setString(3, Date.toString());

            preparedStatement.execute();
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
                students.add(new Student (resultSet.getString("Student_ID"), resultSet.getString("Name"), new Date (resultSet.getString("Date_Of_Birth"))));
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
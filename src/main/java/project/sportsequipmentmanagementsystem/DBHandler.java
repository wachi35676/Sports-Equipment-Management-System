package project.sportsequipmentmanagementsystem;

import java.sql.*;

public class DBHandler extends PersistenceHandler{
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
            preparedStatement.setString(3, student.getDate().getYear() +"-"+ student.getDate().getMonth() + "-" + student.getDate().getDay());

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
}
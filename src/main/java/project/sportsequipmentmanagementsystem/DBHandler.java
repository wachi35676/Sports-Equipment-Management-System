package project.sportsequipmentmanagementsystem;

import java.sql.*;

public class DBHandler {
    private Connection connection = null;

    public void connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEMSDB", "root", "");
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
            String sql = "insert into Student values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getGender());

            preparedStatement.execute();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }
}

package project.sportsequipmentmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WelcomeScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Sports Equipment Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void changeSceneToWelcomeScreen(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WelcomeScreen.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));

        stage.show();
    }

    public void changeSceneToMainStudentScreen(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainStudentScreen.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));

        stage.show();
    }

    public void changeSceneToBorrowEquipment(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("BorrowEquipmentScreen.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));

        stage.show();
    }

    public void changeSceneToPayFine(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PayFineStudentScreen.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));

        stage.show();
    }

}
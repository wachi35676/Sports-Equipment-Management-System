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
        //This is a comment
        System.out.println("This is a change.");
        System.out.println("This is a change.");
        System.out.println("This is a change.");
        int x = 10;
        System.out.println(x + " This is a change.");
    }

    public static void main(String[] args) {
        launch();
    }

    public void changeSceneToPrincipalMenu(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainPrincipalScreen.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));

        stage.show();
    }



    public void changeSceneToStudentMenu(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainStudentScreen.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));

        stage.show();
    }
}
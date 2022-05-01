package project.sportsequipmentmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainSportsTeacherScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Sports Equipment Management System");
        stage.setScene(scene);
        stage.show();
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

    public void changeSceneToTeacherMenu(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainSportsTeacherScreen.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));
        stage.show();
    }

    public void goBackToMainMenu(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WelcomeScreen.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));

        stage.show();
        //This is a temporary change
        System.out.println("This is a change");

    }
    public void changeSceneToEquipmentMenu(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CheckIssuedEquipment.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));
        stage.show();
    }
    public void changeSceneToIssueFine(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("IssueFine.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));
        stage.show();
    }
    public void changeScenetoReturnEquipment(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ReturnIssueEquipment.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));
        stage.show();
    }
}
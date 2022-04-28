package project.sportsequipmentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeScreenController {
    //Defining buttons
    public Button teacherLogIn = new Button();
    public Button studentLogin = new Button();
    public Button principalLogin = new Button();

    public void logInStudent (ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().changeSceneToMainStudentScreen(stage);
    }
}

package project.sportsequipmentmanagementsystem.UIControllers.StudentScreenControllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.sportsequipmentmanagementsystem.Date;
import project.sportsequipmentmanagementsystem.EducationalInstitute;
import project.sportsequipmentmanagementsystem.Main;

import java.io.IOException;

public class BorrowEquipmentScreenController {
    public Button goBackToHome = new Button();
    public Button logOut = new Button();
    public Button borrowButton = new Button();
    public TextField equipmentIDTextField = new TextField();
    public TextField studentIDTextField = new TextField();
    public TextField dateOfBorrowRequestTextField= new TextField();


    public void goBackToHome (ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().changeSceneToMainStudentScreen(stage);
    }

    public void goToWelcomeScreen (ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().changeSceneToWelcomeScreen(stage);
    }

    public void borrowEquipment() {
        new EducationalInstitute().processBorrowRequest(equipmentIDTextField.getText(),studentIDTextField.getText(),new Date(dateOfBorrowRequestTextField.getText()));
    }
}

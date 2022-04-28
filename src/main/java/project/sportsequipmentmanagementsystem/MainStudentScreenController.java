package project.sportsequipmentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStudentScreenController {
    public Button borrowEquipment = new Button();
    public Button payFine = new Button();

    public void borrowEquipment (ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().changeSceneToBorrowEquipment(stage);
    }

    public void payFine (ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().changeSceneToPayFine(stage);
    }

}

package project.sportsequipmentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BorrowEquipmentScreenController {
    public Button goBackToHome = new Button();

    public void goBackToHome (ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().changeSceneToMainStudentScreen(stage);
    }

}

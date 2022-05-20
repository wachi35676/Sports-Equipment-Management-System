package project.sportsequipmentmanagementsystem.UIControllers.TeacherScreenController;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.sportsequipmentmanagementsystem.Main;

import java.io.IOException;

public class IssueFineController {


    public ImageView ManageEQBtn = new ImageView();
    public Button logOutButton = new Button();
    public ImageView equipment = new ImageView();
    public ImageView ReturnERequest = new ImageView();


    public void manageEquipment(MouseEvent mouseEvent) throws IOException {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        new Main().changeSceneToTeacherMenu(stage);

    }

    public void logOut(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().goBackToMainMenu(stage);

    }

    public void CheckEquipment(MouseEvent mouseEvent) throws IOException {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        new Main().changeSceneToEquipmentMenu(stage);

    }

    public void ReturnEquipmentRequest(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        new Main().changeScenetoReturnEquipment(stage);
    }
}

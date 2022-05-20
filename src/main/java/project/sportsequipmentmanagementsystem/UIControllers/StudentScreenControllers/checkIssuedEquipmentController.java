package project.sportsequipmentmanagementsystem.UIControllers.StudentScreenControllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.sportsequipmentmanagementsystem.Main;

import java.io.IOException;

public class checkIssuedEquipmentController {


    public ImageView ManageEQBtn = new ImageView();
    public Button logOutButton = new Button();
    public ImageView equipment = new ImageView();
    public ImageView  IssueFine = new ImageView();


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

    public void IssueFining(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        new Main().changeSceneToIssueFine(stage);

    }
}

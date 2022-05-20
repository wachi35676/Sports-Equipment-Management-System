package project.sportsequipmentmanagementsystem.UIControllers.PrincipalScreenControllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.sportsequipmentmanagementsystem.EducationalInstitute;
import project.sportsequipmentmanagementsystem.Main;

import java.io.IOException;

public class ManageEquipmentController {
    public Button manageEquipmentButton = new Button();
    public Button manageTeacherButton = new Button();
    public Button homeButton = new Button();
    public Button manageStudentButton = new Button();
    public Button logOutButton = new Button();

    public TextField equipmentID = new TextField();
    public TextField name = new TextField();
    public TextField brandName = new TextField();
    public TextField availability = new TextField();
    public TextField room = new TextField();
    public Button addEquipment = new Button();

    public void logOut(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().goBackToMainMenu(stage);
    }

    public void goToHome(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().changeSceneToPrincipalMenu(stage);
    }

    public void goToEquipment(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().changeSceneToManageBorrowEquipment(stage);
    }

    public void goToTeacher(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().changeSceneToManageTeacher(stage);
    }

    public void goToStudent(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        new Main().changeSceneToManageStudent(stage);
    }

    public void addEquipment(ActionEvent event) throws IOException{
        new EducationalInstitute().addEquipment(Integer.parseInt(equipmentID.getText()), name.getText(), brandName.getText(), availability.getText(), room.getText());
    }
}

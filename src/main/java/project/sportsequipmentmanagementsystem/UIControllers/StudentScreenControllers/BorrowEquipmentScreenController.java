package project.sportsequipmentmanagementsystem.UIControllers.StudentScreenControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.sportsequipmentmanagementsystem.Date;
import project.sportsequipmentmanagementsystem.EducationalInstitute;
import project.sportsequipmentmanagementsystem.Main;
import project.sportsequipmentmanagementsystem.SportsRoom.Equipment;
import project.sportsequipmentmanagementsystem.SportsRoom.EquipmentRequests;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BorrowEquipmentScreenController implements Initializable {
    public Button goBackToHome = new Button();
    public Button logOut = new Button();
    public Button borrowButton = new Button();
    public TextField equipmentIDTextField = new TextField();
    public TextField studentIDTextField = new TextField();
    public TextField dateOfBorrowRequestTextField= new TextField();
    public TableView  <Equipment> equipmentTable = new TableView<>();
    public TableColumn<Equipment, String> equipmentIdColumn;
    public TableColumn<Equipment, String> nameColumn;
    public TableColumn<Equipment, String> brandNameColumn;
    public TableColumn<Equipment, String> availabilityColumn;
    public TableColumn<Equipment, String> roomIdColumn;
    ObservableList<Equipment> equipmentObservableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        equipmentObservableList = FXCollections.observableArrayList(getStudentsData());

        equipmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("EquipmentID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        brandNameColumn.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("Availability"));
        roomIdColumn.setCellValueFactory(new PropertyValueFactory<>("Room"));

        equipmentTable.setItems(equipmentObservableList);
    }

    private ArrayList<Equipment> getStudentsData(){
        return new EducationalInstitute().getAllEquipment();
    }

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

        equipmentObservableList = FXCollections.observableArrayList(getStudentsData());
        equipmentTable.setItems(equipmentObservableList);
    }
}

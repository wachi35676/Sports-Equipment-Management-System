package project.sportsequipmentmanagementsystem.UIControllers.TeacherScreenController;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.sportsequipmentmanagementsystem.EducationalInstitute;
import project.sportsequipmentmanagementsystem.Main;
import project.sportsequipmentmanagementsystem.SportsRoom.EquipmentBorrowRecord;
import project.sportsequipmentmanagementsystem.SportsRoom.EquipmentRequests;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReturnIssueEquipmentController implements Initializable {

    public ImageView ManageEQBtn = new ImageView();
    public Button logOutButton = new Button();
    public Button equipmentReturn = new Button();
    public ImageView equipment = new ImageView();
    public  ImageView Fine = new ImageView();

    public TableView<EquipmentBorrowRecord> equipmentBorrowRecordTableView = new TableView<>();
    public TableColumn<EquipmentBorrowRecord,String> borrow_ID;
    public TableColumn<EquipmentBorrowRecord,String> StudentIDcolumn;
    public  TableColumn<EquipmentBorrowRecord,String>   DateOfIssueCol;
    public  TableColumn<EquipmentBorrowRecord,String>   EquipmentIDCol;
    public ObservableList<EquipmentBorrowRecord> equipmentBorrowRecords;

    public    TextField    borrowRecord_ID =      new TextField();
    public    TextField    DateOfReturn   =  new TextField();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        equipmentBorrowRecords = FXCollections.observableList(getIssuedList());

        borrow_ID.setCellValueFactory(new PropertyValueFactory<>("BorrowRecordID"));
        StudentIDcolumn.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        EquipmentIDCol.setCellValueFactory(new PropertyValueFactory<>("EquipmentID"));
        DateOfIssueCol.setCellValueFactory(new PropertyValueFactory<>("IssuedDate"));

        equipmentBorrowRecordTableView.setItems(equipmentBorrowRecords);
    }

    public ArrayList<EquipmentBorrowRecord> getIssuedList(){
        return new EducationalInstitute().getAllCurrentlyBorrowedEquipmentRecords();
    }

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

    public void ReturnEquipement(ActionEvent event) {
        int issueRecord= Integer.parseInt(borrowRecord_ID.getText());
        String  date =    DateOfReturn.getText();
        new EducationalInstitute().returnEquipment(issueRecord,date);
    }
}

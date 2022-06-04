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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IssueFineController  implements Initializable {


    public ImageView ManageEQBtn = new ImageView();
    public Button logOutButton = new Button();
    public ImageView equipment = new ImageView();
    public ImageView ReturnERequest = new ImageView();
    public Button issueFineButton = new Button();
    public TextField amountTextField = new TextField();
    public TextField rollNoTextField = new TextField();
    public TableView<EquipmentBorrowRecord> issueFineTable = new TableView<>();
    public TableColumn<EquipmentBorrowRecord,String> borrowIDColumn = new TableColumn<>();
    public TableColumn<EquipmentBorrowRecord,String> equipmentIDColumn = new TableColumn<>();
    public TableColumn<EquipmentBorrowRecord,String> studentIDColumn = new TableColumn<>();
    public TableColumn<EquipmentBorrowRecord,String> dateOfIssueColumn = new TableColumn<>();
    public TableColumn<EquipmentBorrowRecord,String> dateOfReturnColumn = new TableColumn<>();
    public TableColumn<EquipmentBorrowRecord,String> fineColumn = new TableColumn<>();
    public ObservableList<EquipmentBorrowRecord> List;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List = FXCollections.observableList(getDefaulterList());

        borrowIDColumn.setCellValueFactory(new PropertyValueFactory<>("BorrowRecordID"));
        equipmentIDColumn.setCellValueFactory(new PropertyValueFactory<>("EquipmentID"));
        studentIDColumn.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        dateOfIssueColumn.setCellValueFactory(new PropertyValueFactory<>("DateOfIssue"));
        dateOfReturnColumn.setCellValueFactory(new PropertyValueFactory<>("DateOfReturn"));
        fineColumn.setCellValueFactory(new PropertyValueFactory<>("Fine"));

        issueFineTable.setItems(List);

    }

    private ArrayList<EquipmentBorrowRecord> getDefaulterList(){

        return new EducationalInstitute().getAllBorrowedEquipmentRecords();
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

    public void ReturnEquipmentRequest(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        new Main().changeScenetoReturnEquipment(stage);
    }


    public void issueFine(ActionEvent event) {
        String issueRecordID =   rollNoTextField.getText() ;
        float amount =  Float.parseFloat(  amountTextField.getText() );
        new EducationalInstitute().addFine(issueRecordID,amount);

        List = FXCollections.observableList(getDefaulterList());
        issueFineTable.setItems(List);
    }
}

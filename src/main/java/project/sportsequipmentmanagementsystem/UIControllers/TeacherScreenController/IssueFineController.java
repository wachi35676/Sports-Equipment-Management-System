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
import project.sportsequipmentmanagementsystem.StudentReturnTime;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IssueFineController  {


    public ImageView ManageEQBtn = new ImageView();
    public Button logOutButton = new Button();
    public ImageView equipement = new ImageView();
    public ImageView ReturnERequest = new ImageView();
    public Button  issuefinebtn = new Button();
    public TextField amounttxt = new TextField();
    public TextField  rollnotxt = new TextField();
/*
    TableView<StudentReturnTime> IssueFineTable;
    TableColumn<StudentReturnTime,String> StudentIDcol;
    TableColumn<StudentReturnTime,String> EquipmentNamecol;
    TableColumn<StudentReturnTime,String> EquipmentIDcol;
    TableColumn<StudentReturnTime,String> DaysCol;
*/
    ObservableList<StudentReturnTime> List;
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


    public void IssueFineToStudent(ActionEvent event) {
        int rollno =   Integer.parseInt(  rollnotxt.getText() );
        float amount =  Float.parseFloat(  amounttxt.getText() );
        new EducationalInstitute().IssueFine(rollno,amount);
    }
   /* @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List = FXCollections.observableList(getDefaulterList());
        StudentIDcol.setCellValueFactory(new PropertyValueFactory<>("Studentid"));
        EquipmentNamecol.setCellValueFactory(new PropertyValueFactory<>("EquipmentName"));
        EquipmentIDcol.setCellValueFactory(new PropertyValueFactory<>("EquipmentID"));
        DaysCol.setCellValueFactory(new PropertyValueFactory<>("TimeOFreturn"));
        IssueFineTable.setItems(List);
    }
    public ArrayList<StudentReturnTime> getDefaulterList(){
        return new EducationalInstitute().getDefaulters();
    }
*/
}

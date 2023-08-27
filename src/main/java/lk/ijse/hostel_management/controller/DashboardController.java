package lk.ijse.hostel_management.controller;


import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.StageController;

public class DashboardController {

    @FXML
    private AnchorPane ancPane;

    @FXML
    private JFXButton backBtn;

    @FXML
    private Label dateLbl;

    @FXML
    private JFXButton manageRoomBtn;

    @FXML
    private JFXButton managestudentsBtn;

    @FXML
    private JFXButton pendingPapymentsBtn;

    @FXML
    private JFXButton resevationBtn;

    @FXML
    private Label timeLbl;

    @FXML
    private Label type1;

    @FXML
    private Label type2;

    @FXML
    private Label type3;

    @FXML
    private Label type4;


    @FXML
    void manageRoomBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/roomForm.fxml",ancPane);

    }

    @FXML
    void resevationBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/reservationForm.fxml",ancPane);


    }

    @FXML
    void managestudentsBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/studentForm.fxml",ancPane);

    }

    @FXML
    void pendingPapymentsBtnOnAction(ActionEvent event) {

    }

    @FXML
    void backBtnOnAction(ActionEvent event) {
        backBtn.getScene().getWindow().hide();
        StageController.changeStage("/view/userForm.fxml","Login Page");

    }

    @FXML
    void initialize() {
        dateLbl.setText(LocalDate.now().toString());
        timeLbl.setText(LocalTime.now().toString());
        assert ancPane != null : "fx:id=\"ancPane\" was not injected: check your FXML file 'dashboardForm.fxml'.";
        assert manageRoomBtn != null : "fx:id=\"manageRoomBtn\" was not injected: check your FXML file 'dashboardForm.fxml'.";
        assert resevationBtn != null : "fx:id=\"resevationBtn\" was not injected: check your FXML file 'dashboardForm.fxml'.";

    }


}

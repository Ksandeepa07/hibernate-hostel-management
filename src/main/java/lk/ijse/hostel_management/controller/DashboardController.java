package lk.ijse.hostel_management.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.StageController;

public class DashboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ancPane;

    @FXML
    private Button manageRoomBtn;

    @FXML
    private Button resevationBtn;

    @FXML
    private Button managestudentsBtn;

    @FXML
    void manageRoomBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/roomForm.fxml",ancPane);

    }

    @FXML
    void resevationBtnOnAction(ActionEvent event) {


    }

    @FXML
    void managestudentsBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/studentForm.fxml",ancPane);

    }

    @FXML
    void initialize() {
        assert ancPane != null : "fx:id=\"ancPane\" was not injected: check your FXML file 'dashboardForm.fxml'.";
        assert manageRoomBtn != null : "fx:id=\"manageRoomBtn\" was not injected: check your FXML file 'dashboardForm.fxml'.";
        assert resevationBtn != null : "fx:id=\"resevationBtn\" was not injected: check your FXML file 'dashboardForm.fxml'.";

    }

}

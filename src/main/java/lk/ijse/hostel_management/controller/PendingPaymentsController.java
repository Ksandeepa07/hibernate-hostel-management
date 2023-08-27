package lk.ijse.hostel_management.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.StageController;

public class PendingPaymentsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton backBtn;

    @FXML
    private TableColumn<?, ?> contactCol;

    @FXML
    private TableView<?> pendingPaymentsTbl;

    @FXML
    private TableColumn<?, ?> reservationIdCol;

    @FXML
    private TableColumn<?, ?> studentIdCol;

    @FXML
    private TableColumn<?, ?> studentNameCol;

    @FXML
    private AnchorPane ancPane;

    @FXML
    void backBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/dashboardForm.fxml",ancPane);


    }

    @FXML
    void tblOnAction(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";
        assert contactCol != null : "fx:id=\"contactCol\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";
        assert pendingPaymentsTbl != null : "fx:id=\"pendingPaymentsTbl\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";
        assert reservationIdCol != null : "fx:id=\"reservationIdCol\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";
        assert studentIdCol != null : "fx:id=\"studentIdCol\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";
        assert studentNameCol != null : "fx:id=\"studentNameCol\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";

    }

}

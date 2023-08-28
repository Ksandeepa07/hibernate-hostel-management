package lk.ijse.hostel_management.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.dto.PendingPaymentsDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.PendingPaymentsService;
import lk.ijse.hostel_management.view.tdm.PendingPaymentsTM;

public class PendingPaymentsController {

    PendingPaymentsService pendingPaymentsService= ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.pendingPayments);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton backBtn;

    @FXML
    private TableColumn<?, ?> contactCol;

    @FXML
    private TableView<PendingPaymentsTM> pendingPaymentsTbl;

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

    void getAll(){
        List<PendingPaymentsDTO> list=pendingPaymentsService.getAllPendingPayments();
        ObservableList<PendingPaymentsTM> observableList= FXCollections.observableArrayList();

        for (PendingPaymentsDTO pendingPaymentsDTO : list) {
            observableList.add(new PendingPaymentsTM(
                    pendingPaymentsDTO.getResId(),
                    pendingPaymentsDTO.getStudentId(),
                    pendingPaymentsDTO.getName(),
                    pendingPaymentsDTO.getContact()
            ));

        }

        pendingPaymentsTbl.setItems(observableList);
    }

    void setCellValueFactory(){
        reservationIdCol.setCellValueFactory(new PropertyValueFactory<>("resId"));
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));

    }

    @FXML
    void initialize() {
        getAll();
        setCellValueFactory();
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";
        assert contactCol != null : "fx:id=\"contactCol\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";
        assert pendingPaymentsTbl != null : "fx:id=\"pendingPaymentsTbl\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";
        assert reservationIdCol != null : "fx:id=\"reservationIdCol\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";
        assert studentIdCol != null : "fx:id=\"studentIdCol\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";
        assert studentNameCol != null : "fx:id=\"studentNameCol\" was not injected: check your FXML file 'pendingPaymentsForm.fxml'.";

    }

}

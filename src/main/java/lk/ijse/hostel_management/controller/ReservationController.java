package lk.ijse.hostel_management.controller;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import jdk.dynalink.linker.LinkerServices;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.dto.ReservationDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.ReservationService;
import lk.ijse.hostel_management.view.tdm.ReservationTM;

public class ReservationController {

    ReservationService service= ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.reservation);

    @FXML
    private Button addBtn;

    @FXML
    private AnchorPane ancPane;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private Label dateLbl;

    @FXML
    private Button delereBtn;

    @FXML
    private TextField resIdTxt;

    @FXML
    private TableView<ReservationTM> reservationTbl;

    @FXML
    private TableColumn<?, ?> resevationIdCol;

    @FXML
    private ComboBox<String> roomTypeIdCmb;

    @FXML
    private TableColumn<?, ?> roomTypeIdCol;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private ComboBox<String> statuscmb;

    @FXML
    private ComboBox<String> studentIdCmb;

    @FXML
    private TableColumn<?, ?> studentIdCol;

    @FXML
    private Button updateBtn;

    @FXML
    private JFXButton backBtn;

    @FXML
    void addBtnOnAction(ActionEvent event) {
        boolean isSaved=service.saveReservation(new ReservationDTO(
                resIdTxt.getText(),
                LocalDate.now(),
                studentIdCmb.getValue(),
                roomTypeIdCmb.getValue(),
                statuscmb.getValue()
        ));

        System.out.println(isSaved);

        if (isSaved){
            System.out.println("saved");
        }else{
            System.out.println("not saved");
        }

    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
       boolean isDeleted= service.deleteReservation(new ReservationDTO(
                resIdTxt.getText(),
                LocalDate.now(),
                studentIdCmb.getValue(),
                roomTypeIdCmb.getValue(),
                statuscmb.getValue()));

        if(isDeleted){
            System.out.println("deleted");
        }else{
            System.out.println("not deleted");
        }

    }

    @FXML
    void tblOnAction(MouseEvent event) {

    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {

    }

    void getAll(){
        List<ReservationDTO> reservationDTOS=service.getAllReservation();
        ObservableList<ReservationTM> list=FXCollections.observableArrayList();

        for (ReservationDTO reservationDTO : reservationDTOS) {
            list.add(new ReservationTM(
                    reservationDTO.getResId(),
                    reservationDTO.getDate(),
                    reservationDTO.getStudentId(),
                    reservationDTO.getRoomId(),
                    reservationDTO.getStatus()
            ));

            reservationTbl.setItems(list);

        }
    }

    void setCellValueFactory(){
        resevationIdCol.setCellValueFactory(new PropertyValueFactory<>("resId"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        roomTypeIdCol.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

    }


    @FXML
    void backBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/dashboardForm.fxml",ancPane);

    }

    void loadStudentIds(){

        List<String> list=service.loadStudentIds();
        ObservableList<String> observableList= FXCollections.observableArrayList();
        for (String s : list) {
            observableList.add(s);

        }
        studentIdCmb.setItems(observableList);

    }

    void loadRoomTypeIds(){
        List<String> list=service.loadRoomTypeIds();
        ObservableList<String> observableList= FXCollections.observableArrayList();
        for (String s : list) {
            observableList.add(s);

        }
        roomTypeIdCmb.setItems(observableList);

    }

    @FXML
    void initialize() {
        getAll();
        setCellValueFactory();
        loadStudentIds();
        loadRoomTypeIds();
        dateLbl.setText(LocalDate.now().toString());
        statuscmb.getItems().addAll("Paid","Not Paid");
        assert addBtn != null : "fx:id=\"addBtn\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert ancPane != null : "fx:id=\"ancPane\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert dateLbl != null : "fx:id=\"dateLbl\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert resIdTxt != null : "fx:id=\"resIdTxt\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert roomTypeIdCmb != null : "fx:id=\"roomTypeIdCmb\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert statuscmb != null : "fx:id=\"statuscmb\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert studentIdCmb != null : "fx:id=\"studentIdCmb\" was not injected: check your FXML file 'reservationForm.fxml'.";

    }

}

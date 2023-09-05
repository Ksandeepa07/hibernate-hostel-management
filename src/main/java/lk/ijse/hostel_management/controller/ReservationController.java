package lk.ijse.hostel_management.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.NotificationController;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.dto.ReservationDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.ReservationService;
import lk.ijse.hostel_management.view.tdm.ReservationTM;

import java.time.LocalDate;
import java.util.List;

public class ReservationController {

    ReservationService service = ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.reservation);

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
        if(resIdTxt.getText().isEmpty()|studentIdCmb.getSelectionModel().getSelectedIndex() == -1|roomTypeIdCmb.getSelectionModel().getSelectedIndex() == -1|
        statuscmb.getSelectionModel().getSelectedIndex() == -1){
            NotificationController.ErrorMasseage("please fill all empty fields !");

        }else {
            boolean isSaved = service.saveReservation(new ReservationDTO(
                    resIdTxt.getText(),
                    LocalDate.now(),
                    studentIdCmb.getValue(),
                    roomTypeIdCmb.getValue(),
                    statuscmb.getValue()
            ));

            System.out.println(isSaved);

            if (isSaved) {
                NotificationController.animationMesseage("/assets/tick.gif", "Reservation Added Sucessfully", "Reservation");
                getAll();
                generateNextResvationId();
                studentIdCmb.setValue(null);
                roomTypeIdCmb.setValue(null);
                statuscmb.setValue(null);

            } else {
                System.out.println("not saved");
            }
        }


    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        boolean isDeleted = service.deleteReservation(new ReservationDTO(
                resIdTxt.getText(),
                LocalDate.now(),
                studentIdCmb.getValue(),
                roomTypeIdCmb.getValue(),
                statuscmb.getValue()));

        if (isDeleted) {
            NotificationController.animationMesseage("/assets/tick.gif", "Reservation Deleted Sucessfully", "Reservation");
            getAll();
            studentIdCmb.setValue(null);
            roomTypeIdCmb.setValue(null);
            statuscmb.setValue(null);

            updateBtn.setDisable(true);
            delereBtn.setDisable(true);

        } else {
            System.out.println("not deleted");
        }

    }

    @FXML
    void tblOnAction(MouseEvent event) {
        updateBtn.setDisable(false);
        delereBtn.setDisable(false);
        TablePosition pos = reservationTbl.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<ReservationTM, ?>> columns = reservationTbl.getColumns();

        resIdTxt.setText(columns.get(0).getCellData(row).toString());
        roomTypeIdCmb.setValue(columns.get(1).getCellData(row).toString());
        studentIdCmb.setValue(columns.get(2).getCellData(row).toString());
        dateLbl.setText(columns.get(3).getCellData(row).toString());
        statuscmb.setValue(columns.get(4).getCellData(row).toString());


    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        boolean isUpdated = service.updateReservation(new ReservationDTO(
                resIdTxt.getText(),
                LocalDate.now(),
                studentIdCmb.getValue(),
                roomTypeIdCmb.getValue(),
                statuscmb.getValue()));

        if (isUpdated) {
            NotificationController.animationMesseage("/assets/tick.gif", "Reservation Updated Sucessfully", "Reservation");
            getAll();
            studentIdCmb.setValue(null);
            roomTypeIdCmb.setValue(null);
            statuscmb.setValue(null);

            updateBtn.setDisable(true);
            delereBtn.setDisable(true);
        } else {
            System.out.println("not");
        }

    }

    void getAll() {
        List<ReservationDTO> reservationDTOS = service.getAllReservation();
        ObservableList<ReservationTM> list = FXCollections.observableArrayList();

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

    void setCellValueFactory() {
        resevationIdCol.setCellValueFactory(new PropertyValueFactory<>("resId"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        roomTypeIdCol.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

    }


    @FXML
    void backBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/dashboardForm.fxml", ancPane);

    }

    void loadStudentIds() {

        List<String> list = service.loadStudentIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (String s : list) {
            observableList.add(s);

        }
        studentIdCmb.setItems(observableList);

    }

    void loadRoomTypeIds() {
        List<String> list = service.loadRoomTypeIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (String s : list) {
            observableList.add(s);

        }
        roomTypeIdCmb.setItems(observableList);

    }

    void generateNextResvationId() {
        String id = service.generateNextResevationId();
        resIdTxt.setText(id);

    }

    @FXML
    void initialize() {
        getAll();
        setCellValueFactory();
        loadStudentIds();
        loadRoomTypeIds();
        generateNextResvationId();
        dateLbl.setText(LocalDate.now().toString());
        updateBtn.setDisable(true);
        delereBtn.setDisable(true);
        statuscmb.getItems().addAll("Paid", "Not Paid");
        assert addBtn != null : "fx:id=\"addBtn\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert ancPane != null : "fx:id=\"ancPane\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert dateLbl != null : "fx:id=\"dateLbl\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert resIdTxt != null : "fx:id=\"resIdTxt\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert roomTypeIdCmb != null : "fx:id=\"roomTypeIdCmb\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert statuscmb != null : "fx:id=\"statuscmb\" was not injected: check your FXML file 'reservationForm.fxml'.";
        assert studentIdCmb != null : "fx:id=\"studentIdCmb\" was not injected: check your FXML file 'reservationForm.fxml'.";

    }

}

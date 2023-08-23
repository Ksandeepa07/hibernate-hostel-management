package lk.ijse.hostel_management.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.dto.RoomDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.RoomService;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomController {

    RoomService roomService = ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.Room);
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private AnchorPane ancPane;
    @FXML
    private TextField keyMoneyTxt;
    @FXML
    private TableColumn<?, ?> keyMpneyCol;
    @FXML
    private TableColumn<?, ?> quantityCol;
    @FXML
    private TextField quantityTxt;
    @FXML
    private TableColumn<?, ?> roomTypeIdCol;
    @FXML
    private TextField roomTypeIdTxt;
    @FXML
    private TableColumn<?, ?> tupeCOl;
    @FXML
    private TextField typeTxt;

    @FXML
    void deleteBtnOnACtion(ActionEvent event) {

    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {

        String isSaved=roomService.saveRoom(new RoomDTO(roomTypeIdTxt.getText()
                , typeTxt.getText()
                , keyMoneyTxt.getText()
                , Integer.parseInt(quantityTxt.getText())));

        if(isSaved.equals(roomTypeIdTxt.getText())){
            System.out.println("saved");
        }else{
            System.out.println("not saved");
        }
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {

    }

    @FXML
    void backBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/dashboardForm.fxml", ancPane);

    }

    @FXML
    void initialize() {
        assert ancPane != null : "fx:id=\"ancPane\" was not injected: check your FXML file 'roomForm.fxml'.";
        assert keyMoneyTxt != null : "fx:id=\"keyMoneyTxt\" was not injected: check your FXML file 'roomForm.fxml'.";
        assert keyMpneyCol != null : "fx:id=\"keyMpneyCol\" was not injected: check your FXML file 'roomForm.fxml'.";
        assert quantityCol != null : "fx:id=\"quantityCol\" was not injected: check your FXML file 'roomForm.fxml'.";
        assert quantityTxt != null : "fx:id=\"quantityTxt\" was not injected: check your FXML file 'roomForm.fxml'.";
        assert roomTypeIdCol != null : "fx:id=\"roomTypeIdCol\" was not injected: check your FXML file 'roomForm.fxml'.";
        assert roomTypeIdTxt != null : "fx:id=\"roomTypeIdTxt\" was not injected: check your FXML file 'roomForm.fxml'.";
        assert tupeCOl != null : "fx:id=\"tupeCOl\" was not injected: check your FXML file 'roomForm.fxml'.";
        assert typeTxt != null : "fx:id=\"typeTxt\" was not injected: check your FXML file 'roomForm.fxml'.";

    }

}

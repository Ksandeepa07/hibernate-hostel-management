package lk.ijse.hostel_management.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.dto.RoomDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.RoomService;
import lk.ijse.hostel_management.view.tdm.RoomTM;

import java.net.URL;
import java.util.List;
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
    private TableView<RoomTM> roomTbl;

    @FXML
    private TextField typeTxt;

    @FXML
    void deleteBtnOnACtion(ActionEvent event) {

        boolean isdeleted=roomService.deleteRoom(new RoomDTO(roomTypeIdTxt.getText()
                , typeTxt.getText()
                , keyMoneyTxt.getText()
                , Integer.parseInt(quantityTxt.getText())));

        if (isdeleted){
            getAll();
        }else {
            System.out.println("not deleted");
        }

    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {

        String isSaved = roomService.saveRoom(new RoomDTO(roomTypeIdTxt.getText()
                , typeTxt.getText()
                , keyMoneyTxt.getText()
                , Integer.parseInt(quantityTxt.getText())));

        if (isSaved.equals(roomTypeIdTxt.getText())) {
            getAll();
            System.out.println("saved");
        } else {
            System.out.println("not saved");
        }
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        boolean isUpdated=roomService.updateRoom(new RoomDTO(roomTypeIdTxt.getText()
                , typeTxt.getText()
                , keyMoneyTxt.getText()
                , Integer.parseInt(quantityTxt.getText())));

        if(isUpdated){
            getAll();
        }else{
            System.out.println("not updated");
        }

    }

    @FXML
    void backBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/dashboardForm.fxml", ancPane);

    }

    void getAll() {
        List<RoomDTO> roomDTOList = roomService.getAllRooms();
        ObservableList<RoomTM> list = FXCollections.observableArrayList();

        for (RoomDTO roomDTO : roomDTOList) {
            list.add(new RoomTM(roomDTO.getRoomTypeId(), roomDTO.getType(), roomDTO.getKeyMoney(), roomDTO.getQty()));
        }
        roomTbl.setItems(list);

    }

    void setCellValueFactory() {
        roomTypeIdCol.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        tupeCOl.setCellValueFactory(new PropertyValueFactory<>("type"));
        keyMpneyCol.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("qty"));

    }

    public void tblOnAction(javafx.scene.input.MouseEvent mouseEvent) {
        TablePosition pos = roomTbl.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<RoomTM, ?>> columns = roomTbl.getColumns();

        roomTypeIdTxt.setText(columns.get(0).getCellData(row).toString());
        typeTxt.setText(columns.get(1).getCellData(row).toString());
        keyMoneyTxt.setText(columns.get(2).getCellData(row).toString());
        quantityTxt.setText(columns.get(3).getCellData(row).toString());
    }

    @FXML
    void initialize() {
        getAll();
        setCellValueFactory();
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

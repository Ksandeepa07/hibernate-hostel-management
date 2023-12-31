package lk.ijse.hostel_management.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.DataValidateController;
import lk.ijse.hostel_management.controller.util.NotificationController;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.dto.RoomDTO;
import lk.ijse.hostel_management.dto.StudentDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.RoomService;
import lk.ijse.hostel_management.view.tdm.RoomTM;
import lk.ijse.hostel_management.view.tdm.StudentTM;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

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
    private TableColumn<?, ?> accomadationssCol;
    @FXML
    private TextField roomTypeIdTxt;
    @FXML
    private TableColumn<?, ?> tupeCOl;
    @FXML
    private TableView<RoomTM> roomTbl;
    @FXML
    private TextField typeTxt;
    @FXML
    private JFXButton backBtn;
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private JFXButton deleteBtn;
    @FXML
    private TextField accomadationsTxt;
    @FXML
    private TextField searchTxt;


    List<RoomDTO> roomDTOList;

    @FXML
    void deleteBtnOnACtion(ActionEvent event) {

        if (roomTypeIdTxt.getText().isEmpty() | typeTxt.getText().isEmpty() | keyMoneyTxt.getText().isEmpty() | quantityTxt.getText().isEmpty() | accomadationsTxt.getText().isEmpty()) {
            NotificationController.ErrorMasseage("Please fill all empty fields !");
            roomTypeIdTxt.setStyle("-fx-border-color: red");
            typeTxt.setStyle("-fx-border-color: red");
            quantityTxt.setStyle("-fx-border-color: red");
            keyMoneyTxt.setStyle("-fx-border-color: red");
            accomadationsTxt.setStyle("-fx-border-color: red");
        } else {
            if (DataValidateController.nameValidate(roomTypeIdTxt.getText()) & DataValidateController.nameValidate(typeTxt.getText())
                    & DataValidateController.quantityValidate(quantityTxt.getText()) &DataValidateController.priceValidate(keyMoneyTxt.getText()) & DataValidateController.quantityValidate(accomadationsTxt.getText())) {
                boolean isdeleted = roomService.deleteRoom(new RoomDTO(
                        roomTypeIdTxt.getText(),
                        typeTxt.getText(),
                        keyMoneyTxt.getText(),
                        Integer.parseInt(quantityTxt.getText()),
                        Integer.parseInt(accomadationsTxt.getText())
                ));

                if (isdeleted) {
                    NotificationController.animationMesseage("/assets/tick.gif", "Room Deleted Sucessfully", "Room");
                    getAll();
                    roomTypeIdTxt.setText("");
                    typeTxt.setText("");
                    keyMoneyTxt.setText("");
                    quantityTxt.setText("");
                    accomadationsTxt.setText("");

                    roomTypeIdTxt.setStyle("-fx-border-color: black");
                    typeTxt.setStyle("-fx-border-color: black");
                    quantityTxt.setStyle("-fx-border-color: black");
                    keyMoneyTxt.setStyle("-fx-border-color: black");
                    accomadationsTxt.setStyle("-fx-border-color: black");

                    updateBtn.setDisable(true);
                    deleteBtn.setDisable(true);
                } else {
                    System.out.println("not deleted");
                }
            } else {
                NotificationController.ErrorMasseage("please validate all fields");
            }
        }

    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {

        for (RoomDTO roomDTO : roomDTOList) {
            if (roomTypeIdTxt.getText().equals(roomDTO.getRoomTypeId())){
                NotificationController.ErrorMasseage("This id is already exits !");
                return;
            }
        }

        if (roomTypeIdTxt.getText().isEmpty() | typeTxt.getText().isEmpty() | keyMoneyTxt.getText().isEmpty() | quantityTxt.getText().isEmpty() | accomadationsTxt.getText().isEmpty()) {
              if(roomTypeIdTxt.getText().isEmpty() & typeTxt.getText().isEmpty() & keyMoneyTxt.getText().isEmpty() &quantityTxt.getText().isEmpty() & accomadationsTxt.getText().isEmpty()){
                NotificationController.ErrorMasseage("Please fill all empty fields !");
                roomTypeIdTxt.setStyle("-fx-border-color: red");
                typeTxt.setStyle("-fx-border-color: red");
                quantityTxt.setStyle("-fx-border-color: red");
                keyMoneyTxt.setStyle("-fx-border-color: red");
                accomadationsTxt.setStyle("-fx-border-color: red");

            }else {
                  NotificationController.ErrorMasseage("Please fill all empty fields !");
              }

        } else {

            if (DataValidateController.nameValidate(typeTxt.getText())
                    & DataValidateController.quantityValidate(quantityTxt.getText()) & DataValidateController.priceValidate(keyMoneyTxt.getText()) & DataValidateController.quantityValidate(accomadationsTxt.getText())) {
                boolean isSaved = roomService.saveRoom(new RoomDTO(
                        roomTypeIdTxt.getText(),
                        typeTxt.getText(),
                        keyMoneyTxt.getText(),
                        Integer.parseInt(quantityTxt.getText()),
                        Integer.parseInt(accomadationsTxt.getText())
                ));

                if (isSaved) {
                    NotificationController.animationMesseage("/assets/tick.gif", "Room Saved Sucessfully", "Room");
                    getAll();
                    roomTypeIdTxt.setText("");
                    typeTxt.setText("");
                    keyMoneyTxt.setText("");
                    quantityTxt.setText("");
                    accomadationsTxt.setText("");

                    roomTypeIdTxt.setStyle("-fx-border-color: black");
                    typeTxt.setStyle("-fx-border-color: black");
                    quantityTxt.setStyle("-fx-border-color: black");
                    keyMoneyTxt.setStyle("-fx-border-color: black");
                    accomadationsTxt.setStyle("-fx-border-color: black");

                    updateBtn.setDisable(true);
                    deleteBtn.setDisable(true);

                } else {
                    System.out.println("not saved");
                }

            } else {
                NotificationController.ErrorMasseage("please validate all fields");
            }

        }
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {

        if (roomTypeIdTxt.getText().isEmpty() | typeTxt.getText().isEmpty() | keyMoneyTxt.getText().isEmpty() | quantityTxt.getText().isEmpty() | accomadationsTxt.getText().isEmpty()) {
            NotificationController.ErrorMasseage("Please fill all empty fields !");

        } else {

            if (DataValidateController.nameValidate(typeTxt.getText())
                    & DataValidateController.quantityValidate(quantityTxt.getText()) & DataValidateController.priceValidate(keyMoneyTxt.getText()) & DataValidateController.quantityValidate(accomadationsTxt.getText())) {
                boolean isUpdated = roomService.updateRoom(new RoomDTO(
                        roomTypeIdTxt.getText(),
                        typeTxt.getText(),
                        keyMoneyTxt.getText(),
                        Integer.parseInt(quantityTxt.getText()),
                        Integer.parseInt(accomadationsTxt.getText())
                ));

                if (isUpdated) {
                    NotificationController.animationMesseage("/assets/tick.gif", "Room Updated Sucessfully", "Room");
                    getAll();
                    roomTypeIdTxt.setText("");
                    typeTxt.setText("");
                    keyMoneyTxt.setText("");
                    quantityTxt.setText("");
                    accomadationsTxt.setText("");

                    roomTypeIdTxt.setStyle("-fx-border-color: black");
                    typeTxt.setStyle("-fx-border-color: black");
                    quantityTxt.setStyle("-fx-border-color: black");
                    keyMoneyTxt.setStyle("-fx-border-color: black");
                    accomadationsTxt.setStyle("-fx-border-color: black");

                    updateBtn.setDisable(true);
                    deleteBtn.setDisable(true);
                } else {
                    System.out.println("not updated");
                }

            }else {
                NotificationController.ErrorMasseage("please validate all fields");
            }

//            if (DataValidateController.nameValidate(typeTxt.getText())){
//
//            }else if(DataValidateController.quantityValidate(quantityTxt.getText())){
//
//            }else if(DataValidateController.priceValidate(keyMoneyTxt.getText())){
//
//            }else if(DataValidateController.quantityValidate(accomadationsTxt.getText())){
//
//            }


        }
    }

    @FXML
    void backBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/dashboardForm.fxml", ancPane);

    }

    void getAll() {
        roomDTOList = roomService.getAllRooms();
        ObservableList<RoomTM> list = FXCollections.observableArrayList();

        for (RoomDTO roomDTO : roomDTOList) {
            list.add(new RoomTM(roomDTO.getRoomTypeId(), roomDTO.getType(), roomDTO.getKeyMoney(), roomDTO.getQty(), roomDTO.getAccomadation()));
        }
        roomTbl.setItems(list);

    }

    void setCellValueFactory() {
        roomTypeIdCol.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        tupeCOl.setCellValueFactory(new PropertyValueFactory<>("type"));
        keyMpneyCol.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        accomadationssCol.setCellValueFactory(new PropertyValueFactory<>("accomadations"));


    }

    public void tblOnAction(javafx.scene.input.MouseEvent mouseEvent) {
        updateBtn.setDisable(false);
        deleteBtn.setDisable(false);
        TablePosition pos = roomTbl.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<RoomTM, ?>> columns = roomTbl.getColumns();

        roomTypeIdTxt.setText(columns.get(0).getCellData(row).toString());
        typeTxt.setText(columns.get(1).getCellData(row).toString());
        keyMoneyTxt.setText(columns.get(2).getCellData(row).toString());
        quantityTxt.setText(columns.get(3).getCellData(row).toString());
        accomadationsTxt.setText(columns.get(4).getCellData(row).toString());
    }


    public void idKeyTyped(KeyEvent keyEvent) {
        roomTypeIdTxt.setStyle("-fx-border-color: black");

    }

    public void typeKeyTyped(KeyEvent keyEvent) {
        typeTxt.setStyle("-fx-border-color: black");


    }

    public void quantityKeyTyped(KeyEvent keyEvent) {
        quantityTxt.setStyle("-fx-border-color: black");

    }

    public void moneyKeyTyped(KeyEvent keyEvent) {
        keyMoneyTxt.setStyle("-fx-border-color: black");

    }

    public void acccomadationKetTyped(KeyEvent keyEvent) {
        accomadationsTxt.setStyle("-fx-border-color: black");


    }

    @FXML
    void searchTable(KeyEvent event) {
        String searchValue = searchTxt.getText().trim();
        ObservableList<RoomTM> obList= FXCollections.observableArrayList();
        List<RoomDTO> load = roomService.getAllRooms();
        for (RoomDTO roomDTO : load) {
            obList.add(new RoomTM(roomDTO.getRoomTypeId(),roomDTO.getType(),roomDTO.getKeyMoney(),roomDTO.getQty(),roomDTO.getAccomadation()));
        }

        if (!searchValue.isEmpty()) {
            ObservableList<RoomTM> filteredData = obList.filtered(new Predicate<RoomTM>() {
                @Override
                public boolean test(RoomTM roomTM) {
                    return String.valueOf(roomTM.getRoomTypeId()).toLowerCase().contains(searchValue.toLowerCase());
                }
            });
            roomTbl.setItems(filteredData);
        } else {
            roomTbl.setItems(obList);
        }

    }

    @FXML
    void searchIconClickOnAction(MouseEvent event) {

        for (RoomDTO roomDTO : roomDTOList) {
            if (!searchTxt.getText().equals(roomDTO.getRoomTypeId())){
                if (searchTxt.getText().isEmpty()){

                }else {
                    NotificationController.ErrorMasseage("please enter a valid room id to check !");
                    return;
                }

            }

        }
        if (searchTxt.getText().isEmpty()){
            NotificationController.ErrorMasseage("please enter a room id to check !");
        }else {
            RoomDTO roomDTO= (RoomDTO) roomService.searchRoom(searchTxt.getText());
            roomTypeIdTxt.setText(roomDTO.getRoomTypeId());
            typeTxt.setText(roomDTO.getType());
            keyMoneyTxt.setText(roomDTO.getKeyMoney());
            quantityTxt.setText(String.valueOf(roomDTO.getQty()));
            accomadationsTxt.setText(String.valueOf(roomDTO.getAccomadation()));
        }


    }


    @FXML
    void initialize() {
        updateBtn.setDisable(true);
        deleteBtn.setDisable(true);

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





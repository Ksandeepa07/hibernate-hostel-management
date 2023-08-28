package lk.ijse.hostel_management.controller;


import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.controller.util.TimeController;
import lk.ijse.hostel_management.dto.RoomDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.HomeService;

public class DashboardController {

    HomeService homeService= ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.home);

    @FXML
    private VBox VBoxMain;

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
    private ScrollPane scrolPane;

    @FXML
    private Label timeLbl;

    @FXML
    private Label type1;

    @FXML
    private Label type1NameLbl;

    @FXML
    private Label type1NameLbl2;

    @FXML
    private Label type1NameLbl3;

    @FXML
    private Label type1NameLbl4;

    @FXML
    private Label type1QtyLbl;

    @FXML
    private Label type1QtyLbl114;

    @FXML
    private Label type1QtyLbl13;

    @FXML
    private Label type1QtyLbl2;

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
        StageController.changeScene("/view/pendingPaymentsForm.fxml",ancPane);

    }

    @FXML
    void backBtnOnAction(ActionEvent event) {
        backBtn.getScene().getWindow().hide();
        StageController.changeStage("/view/userForm.fxml","Login Page");

    }

    void getAllRooms(){
        List<RoomDTO> roomDTOList=homeService.getAllRooms();
        for (RoomDTO roomDTO : roomDTOList) {
            if (roomDTO.getQty()==0) {
                Text text = new Text(roomDTO.getRoomTypeId() +"   :      Not Availble");
                text.setFill(Color.WHITE);
                text.setStyle("-fx-font-size: 14");
                TextFlow textFlow = new TextFlow(text);
                textFlow.setStyle("-fx-background-color: #000000; -fx-font-weight: bold;");
                textFlow.setPadding(new Insets(10, 8, 10, 10));
                HBox vBox = new HBox();
                vBox.setHgrow(textFlow, javafx.scene.layout.Priority.ALWAYS);
                vBox.getChildren().add(textFlow);
                VBoxMain.getChildren().add(vBox);
            }else{
                Text text = new Text(roomDTO.getRoomTypeId() +"   :      Availble");
                text.setFill(Color.WHITE);
                text.setStyle("-fx-font-size: 14");
                TextFlow textFlow = new TextFlow(text);
                textFlow.setStyle("-fx-background-color: #000000; -fx-font-weight: bold;  ");
                textFlow.setPadding(new Insets(10, 8, 10, 10));
                HBox vBox = new HBox();
                vBox.setHgrow(textFlow, javafx.scene.layout.Priority.ALWAYS);
                vBox.getChildren().add(textFlow);
                VBoxMain.getChildren().add(vBox);
            }
        }

        if(roomDTOList.size()==4){
            if (roomDTOList.get(0).getQty()==0) {
                type1NameLbl.setText(roomDTOList.get(0).getRoomTypeId());
                type1QtyLbl.setText("Not Available");
            }else{
                type1NameLbl.setText(roomDTOList.get(0).getRoomTypeId());
                type1QtyLbl.setText("Available");
            }

            if (roomDTOList.get(1).getQty()==0) {
                type1NameLbl2.setText(roomDTOList.get(1).getRoomTypeId());
                type1QtyLbl2.setText("Not Available");
            }else {
                type1NameLbl2.setText(roomDTOList.get(1).getRoomTypeId());
                type1QtyLbl2.setText("Available");
            }

            if (roomDTOList.get(2).getQty()==0) {
                type1NameLbl3.setText(roomDTOList.get(2).getRoomTypeId());
                type1QtyLbl13.setText("Not Available");
            }else{
                type1NameLbl3.setText(roomDTOList.get(2).getRoomTypeId());
                type1QtyLbl13.setText("Available");
            }

            if (roomDTOList.get(4).getQty()==0) {
                type1NameLbl4.setText(roomDTOList.get(3).getRoomTypeId());
                type1QtyLbl114.setText("Not Available");
            }else{
                type1NameLbl4.setText(roomDTOList.get(3).getRoomTypeId());
                type1QtyLbl114.setText("Available");
            }

        } else if(roomDTOList.size()==3) {

            if (roomDTOList.get(0).getQty()==0) {
                type1NameLbl.setText(roomDTOList.get(0).getRoomTypeId());
                type1QtyLbl.setText("Not Available");
            }else{
                type1NameLbl.setText(roomDTOList.get(0).getRoomTypeId());
                type1QtyLbl.setText("Available");
            }

            if (roomDTOList.get(1).getQty()==0) {
                type1NameLbl2.setText(roomDTOList.get(1).getRoomTypeId());
                type1QtyLbl2.setText("Not Available");
            }else {
                type1NameLbl2.setText(roomDTOList.get(1).getRoomTypeId());
                type1QtyLbl2.setText("Available");
            }

            if (roomDTOList.get(2).getQty()==0) {
                type1NameLbl3.setText(roomDTOList.get(2).getRoomTypeId());
                type1QtyLbl13.setText("Not Available");
            }else{
                type1NameLbl3.setText(roomDTOList.get(2).getRoomTypeId());
                type1QtyLbl13.setText("Available");
            }

        }else if(roomDTOList.size()==2) {

            if (roomDTOList.get(0).getQty()==0) {
                type1NameLbl.setText(roomDTOList.get(0).getRoomTypeId());
                type1QtyLbl.setText("Not Available");
            }else{
                type1NameLbl.setText(roomDTOList.get(0).getRoomTypeId());
                type1QtyLbl.setText("Available");
            }

            if (roomDTOList.get(1).getQty()==0) {
                type1NameLbl2.setText(roomDTOList.get(1).getRoomTypeId());
                type1QtyLbl2.setText("Not Available");
            }else {
                type1NameLbl2.setText(roomDTOList.get(1).getRoomTypeId());
                type1QtyLbl2.setText("Available");
            }

        }else if(roomDTOList.size()==1) {

            if (roomDTOList.get(0).getQty()==0) {
                type1NameLbl.setText(roomDTOList.get(0).getRoomTypeId());
                type1QtyLbl.setText("Not Available");
            }else{
                type1NameLbl.setText(roomDTOList.get(0).getRoomTypeId());
                type1QtyLbl.setText("Available");
            }
        }
    }

    @FXML
    void initialize() {
        getAllRooms();
        TimeController.timeNow(timeLbl,dateLbl);
        VBoxMain.setSpacing(2);
        assert ancPane != null : "fx:id=\"ancPane\" was not injected: check your FXML file 'dashboardForm.fxml'.";
        assert manageRoomBtn != null : "fx:id=\"manageRoomBtn\" was not injected: check your FXML file 'dashboardForm.fxml'.";
        assert resevationBtn != null : "fx:id=\"resevationBtn\" was not injected: check your FXML file 'dashboardForm.fxml'.";

    }


}

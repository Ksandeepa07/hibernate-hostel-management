package lk.ijse.hostel_management.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.ijse.hostel_management.dto.UserDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.UpadtePwService;

public class UpdatePwController {


    UpadtePwService upadtePwService= ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.updatePw);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField passwordTxt;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private TextField usernameTxt;

    @FXML
    void updateBtnOnAction(ActionEvent event) {
       boolean isUpadted=upadtePwService.upadetePassword(new UserDTO(
                LoginController.userId,
                usernameTxt.getText(),
                passwordTxt.getText()
        ));

       if (isUpadted){
           System.out.println("updated");
       }else {
           System.out.println("not Updated");
       }



    }

    @FXML
    void initialize() {
        System.out.println("Update Controller : "+LoginController.userId);
         assert passwordTxt != null : "fx:id=\"passwordTxt\" was not injected: check your FXML file 'updatePwForm.fxml'.";
        assert updateBtn != null : "fx:id=\"updateBtn\" was not injected: check your FXML file 'updatePwForm.fxml'.";
        assert usernameTxt != null : "fx:id=\"usernameTxt\" was not injected: check your FXML file 'updatePwForm.fxml'.";

    }

}

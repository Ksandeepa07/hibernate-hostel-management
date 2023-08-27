package lk.ijse.hostel_management.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.dto.UserDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.UserService;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ancpane;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private TextField passwordTxt;

    @FXML
    private TextField usernameTxt;

    UserService userService= ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.user);

    @FXML
    void loginBtnOnAction(ActionEvent event) {
//        UserDTO userDTO= (UserDTO) userService.searchUser(1);
//        String userName=userDTO.getUserName();
//        String password=userDTO.getPassword();
//
//        if(usernameTxt.getText().equals(userName)&&passwordTxt.getText().equals(password)){
//            loginBtn.getScene().getWindow().hide();
//            StageController.changeStage("/view/dashboardForm.fxml","Dashboard");
//        }else{
//            System.out.println("login fail");
//        }
         loginBtn.getScene().getWindow().hide();
        StageController.changeStage("/view/dashboardForm.fxml","Dashboard");


    }

    @FXML
    void initialize() {
        assert ancpane != null : "fx:id=\"ancpane\" was not injected: check your FXML file 'userForm.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'userForm.fxml'.";
        assert passwordTxt != null : "fx:id=\"passwordTxt\" was not injected: check your FXML file 'userForm.fxml'.";
        assert usernameTxt != null : "fx:id=\"usernameTxt\" was not injected: check your FXML file 'userForm.fxml'.";

    }

}

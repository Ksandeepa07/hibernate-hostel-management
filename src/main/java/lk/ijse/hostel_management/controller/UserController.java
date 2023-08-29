package lk.ijse.hostel_management.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.dto.UserDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.UserService;

public class UserController {

    UserService userService= ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.user);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ancpane;

    @FXML
    private TextField passwordTxt;

    @FXML
    private JFXButton signUpBtn;

    @FXML
    private TextField userIdTxt;

    @FXML
    private TextField usernameTxt;

    @FXML
    void signUpBtnOnAction(ActionEvent event) {
        boolean isSaved=userService.saveUser(new UserDTO(
                userIdTxt.getText(),
                usernameTxt.getText(),
                passwordTxt.getText()
        ));

        if (isSaved){
            System.out.println("saved");
        }else {
            System.out.println("not saved");
        }

    }

    @FXML
    void initialize() {
        assert ancpane != null : "fx:id=\"ancpane\" was not injected: check your FXML file 'signUpForm.fxml'.";
        assert passwordTxt != null : "fx:id=\"passwordTxt\" was not injected: check your FXML file 'signUpForm.fxml'.";
        assert signUpBtn != null : "fx:id=\"signUpBtn\" was not injected: check your FXML file 'signUpForm.fxml'.";
        assert userIdTxt != null : "fx:id=\"userIdTxt\" was not injected: check your FXML file 'signUpForm.fxml'.";
        assert usernameTxt != null : "fx:id=\"usernameTxt\" was not injected: check your FXML file 'signUpForm.fxml'.";

    }

}

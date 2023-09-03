package lk.ijse.hostel_management.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.hostel_management.controller.util.NotificationController;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.dto.UserDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.LoginService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    static String userId;
    LoginService loginService = ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.login);
    @FXML
    private AnchorPane ancpane;

    @FXML
    private Hyperlink dontHaveAnAccount;

    @FXML
    private ImageView hidePwImg;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField passwordshowTxt;

    @FXML
    private ImageView showPwImg;

    @FXML
    private TextField userIdTxt;

    @FXML
    private TextField usernameTxt;

    @FXML
    void loginBtnOnAction(ActionEvent event) {
        String userName = "";
        String password = "";
        UserDTO userDTO = null;

        if (userIdTxt.getText().isEmpty() | userIdTxt.getText().isEmpty() | passwordTxt.getText().isEmpty()) {
            NotificationController.ErrorMasseage("Please fill all empty fields before continue!");
        }

        userDTO = (UserDTO) loginService.searchUser(userIdTxt.getText());

        if (userDTO == null) {
            userName="ussername";
            password="password";
            if (userIdTxt.getText().isEmpty() | userIdTxt.getText().isEmpty() | passwordTxt.getText().isEmpty()) {

            } else {
                NotificationController.ErrorMasseage("Entered user id is not valid!");

            }
        }

        try {
            userName = userDTO.getUserName();
            password = userDTO.getPassword();
            userId = userDTO.getUserId();
            System.out.println(userDTO);
        } catch (Exception e) {
            System.out.println();
        }

        if ( usernameTxt.getText().equals(userName) && passwordTxt.getText().equals(password)) {
            NotificationController.animationMesseage("/assets/tick.gif", "Login sucessfull", "login");
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event1 -> {
                loginBtn.getScene().getWindow().hide();
                StageController.changeStage("/view/dashboardForm.fxml", "Dashboard");
            }));
            timeline.play();

        }else if (!usernameTxt.getText().equals(userName) && !passwordTxt.getText().equals(password)) {
            if (userDTO == null) {

            }else {
                NotificationController.ErrorMasseage("Check Your Username & Password!");
            }

        }else if (!usernameTxt.getText().equals(userName)) {
            if(usernameTxt.getText().isEmpty()){

            }else{
                NotificationController.ErrorMasseage("Check Your username!");
            }


        }else if (!passwordTxt.getText().equals(password)) {
            if(passwordTxt.getText().isEmpty()){

            }else {
                NotificationController.ErrorMasseage("Check Your password!");
            }

        }


         loginBtn.getScene().getWindow().hide();
        StageController.changeStage("/view/dashboardForm.fxml","Dashboard");


    }

    @FXML
    void dontHaveAnAccountOnAction(ActionEvent event) {
        StageController.changeScene("/view/signUpForm.fxml", ancpane);

    }

    @FXML
    void initialize() {
        passwordshowTxt.setVisible(false);
        hidePwImg.setVisible(false);
        assert ancpane != null : "fx:id=\"ancpane\" was not injected: check your FXML file 'userForm.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'userForm.fxml'.";
        assert passwordTxt != null : "fx:id=\"passwordTxt\" was not injected: check your FXML file 'userForm.fxml'.";
        assert usernameTxt != null : "fx:id=\"usernameTxt\" was not injected: check your FXML file 'userForm.fxml'.";

    }

    public void hidePasswordOnAction(MouseEvent mouseEvent) {
        passwordshowTxt.setVisible(false);
        hidePwImg.setVisible(false);
        passwordTxt.setVisible(true);
        showPwImg.setVisible(true);
        passwordTxt.setText(passwordshowTxt.getText());


    }

    public void showPasswordOnAction(MouseEvent mouseEvent) {
        passwordTxt.setVisible(false);
        showPwImg.setVisible(false);
        passwordshowTxt.setVisible(true);
        hidePwImg.setVisible(true);
        passwordshowTxt.setText(passwordTxt.getText());

    }

}

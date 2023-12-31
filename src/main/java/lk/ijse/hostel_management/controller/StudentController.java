package lk.ijse.hostel_management.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.DataValidateController;
import lk.ijse.hostel_management.controller.util.NotificationController;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.dto.StudentDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.StudentService;
import lk.ijse.hostel_management.view.tdm.StudentTM;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class StudentController {

    StudentService service = ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.student);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TextField addressTxt;

    @FXML
    private AnchorPane ancPane;

    @FXML
    private TableColumn<?, ?> contactCol;

    @FXML
    private TextField contactTxt;

    @FXML
    private TableColumn<?, ?> dobCol;

    @FXML
    private DatePicker dobTxt;

    @FXML
    private ComboBox<String> genderCmb;

    @FXML
    private TableColumn<?, ?> genderCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn<?, ?> studentIdCol;

    @FXML
    private TextField studentIdTxt;

    @FXML
    private TableView<StudentTM> studentTbl;

    @FXML
    private JFXButton backBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private TextField searchTxt;

    List<StudentDTO> studentDTOList;

    @FXML
    void backBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/dashboardForm.fxml", ancPane);

    }

    @FXML
    void deleteBtnOnACtion(ActionEvent event) {

        if (studentIdTxt.getText().isEmpty() | nameTxt.getText().isEmpty() | addressTxt.getText().isEmpty() | contactTxt.getText().isEmpty() | dobTxt.getEditor().getText().isEmpty()
                | genderCmb.getSelectionModel().getSelectedIndex() == -1) {
            NotificationController.ErrorMasseage("Please fill all empty fields !");


        }else {

            if (DataValidateController.nameValidate(nameTxt.getText()) & DataValidateController.addressValidate(addressTxt.getText())
        & DataValidateController.contactCheck(contactTxt.getText())){
                try {

                    boolean idDeleted = service.deleteStudent(new StudentDTO(
                            studentIdTxt.getText(),
                            nameTxt.getText(),
                            addressTxt.getText(),
                            contactTxt.getText(),
                            dobTxt.getValue().toString(),
                            genderCmb.getSelectionModel().getSelectedItem()));

                    if (idDeleted) {
                        NotificationController.animationMesseage("/assets/tick.gif", "Student Deleted Sucessfully", "Studemt");
                        getAll();
                        studentIdTxt.setText("");
                        nameTxt.setText("");
                        addressTxt.setText("");
                        contactTxt.setText("");
                        dobTxt.setValue(null);
                        genderCmb.setValue(null);

                        nameTxt.setStyle("-fx-border-color: black");
                        studentIdTxt.setStyle("-fx-border-color: black");
                        addressTxt.setStyle("-fx-border-color: black");
                        contactTxt.setStyle("-fx-border-color: black");

                        updateBtn.setDisable(true);
                        deleteBtn.setDisable(true);


                    } else {
                        System.out.println("error");
                    }
                }catch (Exception e){
                    System.out.println();
                }
            }else{
                NotificationController.ErrorMasseage("please validate all fields");
            }


        }


    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {
        for (StudentDTO studentDTO : studentDTOList) {
            if (studentIdTxt.getText().equals(studentDTO.getStudentId())){
                NotificationController.ErrorMasseage("This id is already exits !");
                return;
            }
        }

        if (studentIdTxt.getText().isEmpty() | nameTxt.getText().isEmpty() | addressTxt.getText().isEmpty() | contactTxt.getText().isEmpty() | dobTxt.getEditor().getText().isEmpty()
                | genderCmb.getSelectionModel().isEmpty()) {
            NotificationController.ErrorMasseage("Please fill all empty fields !");
        }else{

            if (DataValidateController.nameValidate(nameTxt.getText()) & DataValidateController.addressValidate(addressTxt.getText())
            &DataValidateController.contactCheck(contactTxt.getText())){
                try {
                    boolean isSaved = service.saveStudent(new StudentDTO(
                            studentIdTxt.getText(),
                            nameTxt.getText(),
                            addressTxt.getText(),
                            contactTxt.getText(),

                            dobTxt.getValue().toString(),
                            genderCmb.getSelectionModel().getSelectedItem()
                    ));

                    if (isSaved) {
                        NotificationController.animationMesseage("/assets/tick.gif", "Student Saved Sucessfully", "Studemt");
                        getAll();
                        studentIdTxt.setText("");
                        nameTxt.setText("");
                        addressTxt.setText("");
                        contactTxt.setText("");
                        dobTxt.setValue(null);
                        genderCmb.setValue(null);

                        nameTxt.setStyle("-fx-border-color: black");
                        studentIdTxt.setStyle("-fx-border-color: black");
                        addressTxt.setStyle("-fx-border-color: black");
                        contactTxt.setStyle("-fx-border-color: black");

                        updateBtn.setDisable(true);
                        deleteBtn.setDisable(true);


                    } else {
                        System.out.println("not saved");
                    }
                }catch (Exception e){
                    System.out.println();
                }
            }else{
                NotificationController.ErrorMasseage("please validate all fields");
            }


        }

    }

    @FXML
    void tblOnAction(MouseEvent event) {
        updateBtn.setDisable(false);
        deleteBtn.setDisable(false);
        TablePosition pos = studentTbl.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        ObservableList<TableColumn<StudentTM, ?>> columns = studentTbl.getColumns();

        studentIdTxt.setText(columns.get(0).getCellData(row).toString());
        nameTxt.setText(columns.get(1).getCellData(row).toString());
        addressTxt.setText(columns.get(2).getCellData(row).toString());
        contactTxt.setText(columns.get(3).getCellData(row).toString());
        dobTxt.setValue(LocalDate.parse(columns.get(4).getCellData(row).toString()));
        genderCmb.setValue(columns.get(5).getCellData(row).toString());

    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {

        if (studentIdTxt.getText().isEmpty() | nameTxt.getText().isEmpty() | addressTxt.getText().isEmpty() | contactTxt.getText().isEmpty() | dobTxt.getEditor().getText().isEmpty()
                | genderCmb.getSelectionModel().getSelectedIndex() == -1) {
            NotificationController.ErrorMasseage("Please fill all empty fields !");
        }else{
            if (DataValidateController.nameValidate(nameTxt.getText()) & DataValidateController.addressValidate(addressTxt.getText())
        & DataValidateController.contactCheck(contactTxt.getText())){
                try {
                    boolean isUpdated = service.updateStudent(
                            new StudentDTO(
                                    studentIdTxt.getText(),
                                    nameTxt.getText(),
                                    addressTxt.getText(),
                                    contactTxt.getText(),
                                    dobTxt.getValue().toString(),
                                    genderCmb.getSelectionModel().getSelectedItem()));

                    if (isUpdated) {
                        NotificationController.animationMesseage("/assets/tick.gif", "Student Updated Sucessfully", "Studemt");
                        getAll();
                        studentIdTxt.setText("");
                        nameTxt.setText("");
                        addressTxt.setText("");
                        contactTxt.setText("");
                        dobTxt.setValue(null);
                        genderCmb.setValue(null);

                        nameTxt.setStyle("-fx-border-color: black");
                        studentIdTxt.setStyle("-fx-border-color: black");
                        addressTxt.setStyle("-fx-border-color: black");
                        contactTxt.setStyle("-fx-border-color: black");

                        updateBtn.setDisable(true);
                        deleteBtn.setDisable(true);


                    } else {
                        System.out.println("not");
                    }

                }catch (Exception e){
                    System.out.println();
                }

            }else {
                NotificationController.ErrorMasseage("please validate all fields");
            }
        }




    }

    void getAll() {
        studentDTOList = service.getAllStudents();
        ObservableList<StudentTM> list = FXCollections.observableArrayList();
        for (StudentDTO studentDTO : studentDTOList) {
            list.add(new StudentTM(
                    studentDTO.getStudentId(),
                    studentDTO.getName(),
                    studentDTO.getAddress(),
                    studentDTO.getConatct(),
                    studentDTO.getDob(),
                    studentDTO.getGender()
            ));

        }
        studentTbl.setItems(list);

    }

    void setCellValueFactory() {
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("conatct"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }


    @FXML
    void searchTable(KeyEvent event) {
        String searchValue = searchTxt.getText().trim();
        ObservableList<StudentTM> obList= FXCollections.observableArrayList();
        List<StudentDTO> load = service.getAllStudents();
        for (StudentDTO studentDTO : load) {
            obList.add(new StudentTM(studentDTO.getStudentId(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getConatct(),studentDTO.getDob(),studentDTO.getGender()));
        }

        if (!searchValue.isEmpty()) {
            ObservableList<StudentTM> filteredData = obList.filtered(new Predicate<StudentTM>() {
                @Override
                public boolean test(StudentTM studentTM) {
                    return String.valueOf(studentTM.getStudentId()).toLowerCase().contains(searchValue.toLowerCase());
                }
            });
            studentTbl.setItems(filteredData);
        } else {
            studentTbl.setItems(obList);
        }

    }


    @FXML
    void searchIconClickOnAction(MouseEvent event) {
        for (StudentDTO studentDTO : studentDTOList) {
            if(!searchTxt.getText().equals(studentDTO.getStudentId())){
                if (searchTxt.getText().isEmpty()){
                }else {
                    NotificationController.ErrorMasseage("please enter a valid student id to check !");
                    return;
                }
            }
        }
        if (searchTxt.getText().isEmpty()){
            NotificationController.ErrorMasseage("please enter a student id to check !");
        }else {
            try {
                StudentDTO studentDTO= (StudentDTO) service.searchStudent(searchTxt.getText());
                studentIdTxt.setText(studentDTO.getStudentId());
                nameTxt.setText(studentDTO.getName());
                addressTxt.setText(studentDTO.getAddress());
                contactTxt.setText(studentDTO.getConatct());
                dobTxt.setValue(LocalDate.parse(studentDTO.getDob()));
                genderCmb.setValue(studentDTO.getGender());

            }catch (Exception e){
                System.out.println();
            }
        }


    }

    @FXML
    void initialize() {
        updateBtn.setDisable(true);
        deleteBtn.setDisable(true);
        genderCmb.getItems().addAll("Male", "Female");
        getAll();
        setCellValueFactory();
        assert addressCol != null : "fx:id=\"addressCol\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert addressTxt != null : "fx:id=\"addressTxt\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert ancPane != null : "fx:id=\"ancPane\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert contactCol != null : "fx:id=\"contactCol\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert contactTxt != null : "fx:id=\"contactTxt\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert dobCol != null : "fx:id=\"dobCol\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert dobTxt != null : "fx:id=\"dobTxt\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert genderCmb != null : "fx:id=\"genderCmb\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert genderCol != null : "fx:id=\"genderCol\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert nameTxt != null : "fx:id=\"nameTxt\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert studentIdCol != null : "fx:id=\"studentIdCol\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert studentIdTxt != null : "fx:id=\"studentIdTxt\" was not injected: check your FXML file 'studentForm.fxml'.";
        assert studentTbl != null : "fx:id=\"studentTbl\" was not injected: check your FXML file 'studentForm.fxml'.";

    }



}

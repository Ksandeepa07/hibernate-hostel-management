package lk.ijse.hostel_management.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management.controller.util.StageController;
import lk.ijse.hostel_management.dto.StudentDTO;
import lk.ijse.hostel_management.service.ServiceFactory;
import lk.ijse.hostel_management.service.custom.StudentService;
import lk.ijse.hostel_management.view.tdm.RoomTM;
import lk.ijse.hostel_management.view.tdm.StudentTM;

public class StudentController {

    StudentService service= ServiceFactory.getInstance().getService(ServiceFactory.serviceTypes.student);

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
    void backBtnOnAction(ActionEvent event) {
        StageController.changeScene("/view/dashboardForm.fxml",ancPane);

    }

    @FXML
    void deleteBtnOnACtion(ActionEvent event) {
       boolean idDeleted=service.deleteStudent(new StudentDTO(
                studentIdTxt.getText(),
                nameTxt.getText(),
                addressTxt.getText(),
                contactTxt.getText(),
                dobTxt.getValue().toString(),
                genderCmb.getSelectionModel().getSelectedItem()));

        if(idDeleted){
            getAll();
        }else{
            System.out.println("error");
        }

    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {

        boolean isSaved=service.saveStudent(new StudentDTO(
                studentIdTxt.getText(),
                nameTxt.getText(),
                addressTxt.getText(),
                contactTxt.getText(),
                dobTxt.getValue().toString(),
                genderCmb.getSelectionModel().getSelectedItem()
        ));

        if (isSaved) {
            getAll();

        } else {
            System.out.println("not saved");
        }

    }

    @FXML
    void tblOnAction(MouseEvent event) {
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

        boolean isUpdated=service.updateStudent(
                new StudentDTO(
                        studentIdTxt.getText(),
                        nameTxt.getText(),
                        addressTxt.getText(),
                        contactTxt.getText(),
                        dobTxt.getValue().toString(),
                        genderCmb.getSelectionModel().getSelectedItem()));

        if(isUpdated){
            getAll();
        }else {
            System.out.println("not");
        }

    }

    void getAll(){
        List<StudentDTO> studentDTOList= service.getAllStudents();
        ObservableList<StudentTM> list= FXCollections.observableArrayList();
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

    void setCellValueFactory(){
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("conatct"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));


    }

    @FXML
    void initialize() {
        genderCmb.getItems().addAll("Male","Female");
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

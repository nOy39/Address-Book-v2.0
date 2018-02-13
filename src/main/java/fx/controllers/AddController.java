package fx.controllers;

import dao.Base;
import dao.CRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController {

    static Base base = new Base();


    @FXML
    private Button btnClear;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField fieldFirstName;
    @FXML
    private TextField fieldLastName;
    @FXML
    private TextField fieldPhone;
    @FXML
    private TextField fieldEmail;


    public void handleClear(ActionEvent actionEvent) {
        fieldFirstName.clear();
        fieldLastName.clear();
        fieldPhone.clear();
        fieldEmail.clear();
    }

    public void handleSave(ActionEvent actionEvent) {
        ErrorControllers ec = new ErrorControllers();
        boolean error = false;
        if (fieldFirstName.getText().length() < 3 && fieldPhone.getText().length() < 5) {
            error = true;
            ec.ErrorStatus(error,"Поле ИМЯ/ТЕЛЕФОН не может быть пустым!");
            ec.windowError(actionEvent);
        } else {
            base.addPerson(fieldFirstName.getText(), fieldLastName.getText(), fieldPhone.getText(), fieldEmail.getText());
            handleClear(actionEvent);
        }
    }

    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}

package fx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class MainController {

    @FXML
    private TableView table;
    @FXML
    private TableColumn columnFirstName;
    @FXML
    private TableColumn columnLastName;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnExit;
    @FXML
    private Label labelFirstName;
    @FXML
    private Label labelLastName;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelPhone;

    public void handleAdd() {

    }

    public void handleRefresh() {

    }

    public void handleExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();

    }

    public void handleEdit() {

    }


}

package fx.controllers;

import dao.ConnectDB;
import helpers.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class MainController implements Initializable{

    private ObservableList<Person> personList;

    @FXML
    private TableView<Person> table;
    @FXML
    private TableColumn<Person, String> columnFirstName;
    @FXML
    private TableColumn<Person, String> columnLastName;
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

    ConnectDB connectDB = new ConnectDB();

    public Connection connection = connectDB.connect();

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


    public void initialize(URL location, ResourceBundle resources) {
        connectDB.connect();
        personList = FXCollections.observableArrayList();

        ResultSet rs = null;
        try {
            rs = connectDB.connect().createStatement().executeQuery("SELECT * FROM abtabla");
            while (rs.next()) {
                personList.add(new Person(rs.getString("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phone"),
                        rs.getString("email")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        columnFirstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

        table.setItems(personList);

        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                        -> showPersonDetails(newValue, labelFirstName, labelLastName, labelPhone, labelEmail));
}

    public void showPersonDetails(Person person, Label labelFirstName, Label labelLastName, Label labelPhone, Label labelEmail) {
        if (person != null) {
            labelFirstName.setText(person.getFirstName());
            labelLastName.setText(person.getLastName());
            labelPhone.setText(person.getPhone());
            labelEmail.setText(person.getEmail());
        }
    }
    }




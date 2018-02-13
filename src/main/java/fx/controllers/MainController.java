package fx.controllers;

import dao.Base;
import dao.ConnectDB;
import helpers.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class MainController implements Initializable{

    private ObservableList<Person> personList;

    @FXML
    private Label labelStatus;
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

    //TODO Сделать метод добавления данных в таблицу 600*183
    public void handleAdd(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/add.fxml"));
            stage.setTitle("Добавить запись");
            stage.setMinHeight(183);
            stage.setMinWidth(600);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleRefresh(ActionEvent actionEvent) {
        initialize(null,null);
    }

    public void refresh() {
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
    }

    public void handleExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();

    }

    public void handleDelete(ActionEvent actionEvent) {
        inProgress(actionEvent);
    }

    //TODO Сделать редактирование записи
    public void handleEdit(ActionEvent actionEvent) {
        inProgress(actionEvent);
    }

    public void inProgress(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/progress.fxml"));
            stage.setTitle("В разработке.");
            stage.setMinHeight(311);
            stage.setMinWidth(504);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(URL location, ResourceBundle resources) {

        refresh();

        columnFirstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

        table.setItems(personList);

        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                        -> showPersonDetails(newValue, labelFirstName, labelLastName, labelPhone, labelEmail));
}

    public void showPersonDetails(Person person, Label labelFirstName,
                                  Label labelLastName, Label labelPhone, Label labelEmail) {
        if (person != null) {
            labelFirstName.setText(person.getFirstName());
            labelLastName.setText(person.getLastName());
            labelPhone.setText(person.getPhone());
            labelEmail.setText(person.getEmail());
        }
    }



    public void showAddTips(MouseEvent mouseEvent) {
        labelStatus.setText(btnAdd.getText());
        }

    /**
     * Метод hideTips
     * @param mouseEvent
     * Убирает подсказку в трее когда мышка сводится с Button
     */
    public void hideTips(MouseEvent mouseEvent) {
        labelStatus.setText("");
    }

    /**
     * Метод showRefreshTips
     * @param mouseEvent
     * отображает подсказу в трее при наведении мышки
     * на Button btnRefresh
     */
    public void showRefreshTips(MouseEvent mouseEvent) {
        labelStatus.setText(btnRefresh.getText());
    }


    public void showEditTips(MouseEvent mouseEvent) {
        labelStatus.setText(btnEdit.getText());
    }

    public void showExitTips(MouseEvent mouseEvent) {
        labelStatus.setText(btnExit.getText());
    }

}




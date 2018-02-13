package dao;

import fx.controllers.ErrorControllers;
import fx.controllers.MainController;
import helpers.Constant;
import helpers.Error;
import helpers.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class Base implements CRUD {

    public static PreparedStatement preparedStatement;
    ConnectDB connectDB = new ConnectDB();
    public Connection connection = connectDB.connect();
    public ErrorControllers ec = new ErrorControllers();

    public void add() {

    }

    private void saveToBase() {

    }

    public void update() {

    }

    public void delete() {

    }

    /**
     *
     if (firstName.equals(null)) {
     System.out.println("Name empty");
     ec.windowError(actionEvent);
     ec.ErrorStatus("Имя не может быть пустым!!!");
     }
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     */
    public void addPerson(String firstName, String lastName, String phone, String email) {

        try {
            preparedStatement = connection.prepareStatement(Constant.getAddQuery());

                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3,phone);
                preparedStatement.setString(4,email);
                preparedStatement.setDate(5,new Date(Calendar.getInstance().getTimeInMillis()));
                preparedStatement.execute();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

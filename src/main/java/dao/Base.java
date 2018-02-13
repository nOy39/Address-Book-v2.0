package dao;

import fx.controllers.ErrorControllers;
import fx.controllers.MainController;
import helpers.Constant;
import helpers.Error;
import helpers.Person;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void addPerson(String firstName, String lastName, String phone, String email) {
        ActionEvent actionEvent = null;
        try {
            preparedStatement = connection.prepareStatement(Constant.getAddQuery());

            if (firstName.equals(null)) {
                System.out.println("Name empty");
                ec.windowError(actionEvent);
                ec.ErrorStatus("Имя не может быть пустым!!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

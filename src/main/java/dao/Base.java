package dao;

import fx.controllers.MainController;
import helpers.Constant;
import helpers.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Base implements CRUD {

    public static PreparedStatement preparedStatement;
    ConnectDB connectDB = new ConnectDB();
    Connection connection = connectDB.connect();

    public void add() {
        saveToBase();
    }

    private void saveToBase() {
    }

    public void update() {

    }

    public void delete() {

    }
}

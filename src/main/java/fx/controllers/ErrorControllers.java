package fx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

//w500*h160
public class ErrorControllers {

    @FXML
    public Label labelErrorStatus;
    @FXML
    private Button btnOk;

    public void handleOk(ActionEvent actionEvent) {
        Stage stage = (Stage) btnOk.getScene().getWindow();
        stage.close();
    }

    public void setLabelErrorStatus(Label labelErrorStatus) {
        this.labelErrorStatus = labelErrorStatus;
    }

   public void windowError(ActionEvent actionEvent) {
        try {
            Label label = new Label("Поле не может быть пустым");
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Error.fxml"));
            stage.setTitle("Ошибка");
            stage.setMinHeight(160);
            stage.setMinWidth(500);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ErrorStatus(boolean status, String s) {
        if (status) {
            System.out.println(s);
        }
    }
}

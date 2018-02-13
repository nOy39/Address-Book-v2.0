import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Boot extends Application {

    public Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().
                getClassLoader().
                getResource("main.fxml"));

        primaryStage.setTitle("AddressBook v2");
        Scene scene = new Scene(root, 700, 500);

        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(500);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("ChatViewer.fxml"));
        Image icon = new Image("sample/media/icon.jpg");

        stage = primaryStage;
        stage.getIcons().add(icon);
        stage.setTitle("ChatViewer");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //closing
        stage.setOnCloseRequest(event -> {
            exit(stage);
            event.consume();
        });
    }
    //Ask user for confirmation on exit
    public void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to leave the Chat Viewer.");
        alert.setContentText("Are you sure you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }
}
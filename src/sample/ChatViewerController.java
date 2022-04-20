package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ChatViewerController implements Initializable {
    private File file = null;
    private String[] fileTypes = {".msg",".txt",".tex"};

    @FXML
    private ChoiceBox<String> fileTypeChoice;

    @FXML
    private Label filePath;

    @FXML
    private TextFlow textFlow;

    @FXML
    private ScrollPane scrollPane;

    /**
     * Allows the user to choose the file and opens the corresponding chat content in the defined format.
     * @param actionEvent
     * @throws IOException
     */
    public void chooseFile(javafx.event.ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        ChatViewer chatViewer = new ChatViewer();
        CheckFileExtension checkFileExtension = new CheckFileExtension();

        //Sets the initial directory to the previously opened directory
        if (file != null) {
            fileChooser.setInitialDirectory(file.getParentFile());
        }

        //Opens the file, checks if it is empty or not
        file = fileChooser.showOpenDialog(Main.stage);
        if (file == null) {
            new Alert(Alert.AlertType.WARNING, "No File Chosen", ButtonType.OK).showAndWait();
            return;
        }

        String fileExtension = checkFileExtension.checkExtension(file);
        String chosenExtension = fileTypeChoice.getValue();

        //Compares the fileExtension and chosenExtension and resets the chat window
        if (fileExtension.equals(chosenExtension)){
            textFlow.getChildren().clear();
            textFlow.getChildren().addAll(chatViewer.viewChat(file));
            scrollPane.setVisible(true);
            filePath.setText("Opened File: " + file.getAbsolutePath());
        }
        else {
            new Alert(Alert.AlertType.ERROR,
                    "Wrong file extension. Expected - " + chosenExtension + ", Received - " + fileExtension,
                    ButtonType.OK).showAndWait();
            return;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileTypeChoice.getItems().addAll(fileTypes);
    }
}

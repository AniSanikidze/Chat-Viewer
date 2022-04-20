package sample;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class BasicNameFormatDefiner extends NameFormatDefiner {
    private String username = " ";
    Text nameTextNode;
    Text defineName(String input, int lineCount) {
        if (!input.isBlank()){
            if (input.contains(username)){
                nameTextNode = new Text("...:");
                username = input;
            }
            else {
                username = input;
                nameTextNode = new Text(username + ":");
            }
            nameTextNode.setFill(Color.BLUE);
            nameTextNode.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
            return nameTextNode;
        }
        else {
            new Alert(Alert.AlertType.ERROR,
                    "Wrong file format. Name content is empty - " + lineCount,
                    ButtonType.OK).showAndWait();
            return null;
        }
    }
}

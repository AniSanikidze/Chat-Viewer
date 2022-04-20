package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BasicTimeFormatDefiner extends TimeFormatDefiner {
    Text timeTextNode;

    Text defineTime(String input, int lineCount) {
        if (!input.isBlank()){
            String time = "[" + input + "]";
            timeTextNode = new Text(time);
            timeTextNode.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
            return timeTextNode;
        }
        else {
            new Alert(Alert.AlertType.ERROR,
                    "Wrong file format. Name content is empty - " + lineCount,
                    ButtonType.OK).showAndWait();
            return null;
        }
    }
}

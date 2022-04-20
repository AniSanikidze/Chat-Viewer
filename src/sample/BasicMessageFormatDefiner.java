package sample;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class BasicMessageFormatDefiner extends MessageFormatDefiner {
    List<Node> list = new ArrayList<>();

    List<Node> defineMessage(String input) {
        String[] words = input.split(" ");
        for (String word : words){
            if (word.contains(":)")) {
                ImageView smile = new ImageView("sample/media/smile_happy.gif");
                list.add(smile);
            }
            else if (word.contains(":(")){
                ImageView sad = new ImageView("sample/media/smile_sad.gif");
                list.add(sad);
            }
            else {
                Text text = new Text(word + " ");
                text.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                list.add(text);
            }
        }
        list.add(new Text("\n"));
        return list;
    }
}

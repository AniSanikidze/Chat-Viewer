package sample;

import javafx.scene.Node;

import java.util.List;

public abstract class MessageFormatDefiner {
    abstract List<Node> defineMessage(String input);
}

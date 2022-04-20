package sample;

import javafx.scene.text.Text;

public abstract class NameFormatDefiner {
    abstract Text defineName(String input, int lineCount);
}
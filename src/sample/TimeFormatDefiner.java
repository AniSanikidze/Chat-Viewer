package sample;

import javafx.scene.text.Text;

public abstract class TimeFormatDefiner{
    abstract Text defineTime(String input, int lineCount);
}
package sample;

import javafx.scene.Node;

import java.io.File;
import java.io.IOException;
import java.util.List;

abstract class ChatContent {
    /**
     * Checks if the given line is empty or not
     * @param line
     * @return boolean
     */
    abstract boolean lineIsNotEmpty(String line);

    /**
     * Checks if the given empty line should be empty or not.
     * @param lineCount Count of already read lines.
     * @param nodeList list of Name,Time and Message nodes.
     * @return boolean
     */
    abstract boolean wrongLineIsEmpty(int lineCount,List<Node> nodeList);

    /**
     * Checks if the line contains the keyword.
     * @param foundKeyword True or False
     * @param lineCount Count of already read lines.
     * @return boolean
     */
    abstract boolean keywordNotFound (boolean foundKeyword, int lineCount);

    /**
     * Checks the format of found keyword and colon of the given line and defines content.
     * @param line
     * @param lineCount Count of already read lines.
     * @param keyword
     * @return Defined line content
     */
    abstract String checkAndDefineLineFormat (String line,int lineCount,String keyword);

    /**
     * Checks if the file contains just one or more messages.
     * @param lineCount Count of already read lines.
     * @param nodeList list of Name,Time and Message nodes.
     * @return boolean
     */
    abstract boolean onlyOneMessageFound(int lineCount, List<Node> nodeList);

    /**
     * Defines the whole content of the chat.
     * @param file Chosen file
     * @return list of defined Name,Time and Message nodes.
     * @throws IOException
     */
    abstract List<Node> defineContent(File file) throws IOException;
}
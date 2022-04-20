package sample;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasicChatContent extends ChatContent {
    private List<Node> nodeList = new ArrayList<>();

    @Override
    boolean lineIsNotEmpty(String line) {
        return line != null && line.length() > 0;
    }

    @Override
    boolean wrongLineIsEmpty (int lineCount,List<Node> listNode) {
        if (lineCount % 4 != 0) {
            new Alert(Alert.AlertType.ERROR,
                    "Wrong file format. Line - " + lineCount + " is empty.",
                    ButtonType.OK).showAndWait();
            listNode.clear();
            return true;
        }
        return false;
    }

    @Override
    boolean keywordNotFound (boolean foundKeyword, int lineCount) {
        if(!foundKeyword){
            new Alert(Alert.AlertType.ERROR,
                    "Wrong file format. No keyword is specified on line - " + lineCount,
                    ButtonType.OK).showAndWait();
            return true;
        }
        return false;
    }

    @Override
    String checkAndDefineLineFormat (String line,int lineCount,String keyword){
        if (line.indexOf(keyword + ":") == 0){
            int index = line.indexOf(":");
            String content = line.substring(index + 1, line.length() );
            return content;
        }
        else {
            new Alert(Alert.AlertType.ERROR,
                    "Wrong file format. Colon on line - " + lineCount + " has an incorrect format.",
                    ButtonType.OK).showAndWait();
            return "";
        }
    }

    @Override
    boolean onlyOneMessageFound (int lineCount,List<Node> nodeList) {
        if (lineCount < 5) {
            new Alert(Alert.AlertType.ERROR,
                    "Wrong file format. Only one message was detected.",
                    ButtonType.OK).showAndWait();
            nodeList.clear();
            return true;
        }
        return false;
    }

    @Override
    List<Node> defineContent(File file) throws IOException {
        TimeFormatDefiner timeFormatDefiner = new BasicTimeFormatDefiner();
        NameFormatDefiner nameFormatDefiner = new BasicNameFormatDefiner();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String[] Arr = {"Time", "Name", "Message"};
        int lineCount = 0;
        String line;

        do {
            line = bufferedReader.readLine();
            lineCount++;
            boolean foundKeyword = false;
            if (lineIsNotEmpty(line)){
                    for (String keyword : Arr) {
                        if(line.contains(keyword)) {
                            foundKeyword = true;
                            String content = checkAndDefineLineFormat(line,lineCount,keyword);
                            if (keyword == "Time") {
                                nodeList.add(timeFormatDefiner.defineTime(content,lineCount));
                            }
                            else if (keyword == "Name") {
                                nodeList.add(nameFormatDefiner.defineName(content,lineCount));
                            }
                            else {
                                MessageFormatDefiner messageFormatDefiner = new BasicMessageFormatDefiner();
                                nodeList.addAll(messageFormatDefiner.defineMessage(content));
                            }
                        }
                    }
                keywordNotFound(foundKeyword,lineCount);
                }
            else {
                wrongLineIsEmpty(lineCount,nodeList);
            }
        }while (line != null);

        onlyOneMessageFound(lineCount,nodeList);

        return nodeList;
        }
    }
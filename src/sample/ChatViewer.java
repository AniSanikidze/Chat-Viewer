package sample;

import javafx.scene.Node;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ChatViewer {
    //Defining the components of ChatViewer
    ChatContent chatContent;
    TimeFormatDefiner timeFormatDefiner;
    NameFormatDefiner nameFormatDefiner;
    MessageFormatDefiner messageFormatDefiner;

    ChatViewer() {
        chatContent = new BasicChatContent();
        timeFormatDefiner = new BasicTimeFormatDefiner();
        nameFormatDefiner = new BasicNameFormatDefiner();
        messageFormatDefiner = new BasicMessageFormatDefiner();
    }

    List<Node> viewChat (File file) throws IOException {
        BasicChatContent basicChatContent = new BasicChatContent();
        return basicChatContent.defineContent(file);
    }
}
package sample;

import javafx.scene.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BasicMessageFormatDefinerTest {

    @Test
    public void defineMessage() {

        BasicMessageFormatDefiner basicMessageFormatDefiner = new BasicMessageFormatDefiner();
        List<Node> messageNodeList = basicMessageFormatDefiner.defineMessage("Hey Adam");

        assertEquals(messageNodeList,basicMessageFormatDefiner.list);
    }
}
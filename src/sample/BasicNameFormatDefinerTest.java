package sample;

import javafx.scene.text.Text;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicNameFormatDefinerTest {

    @Test
    public void defineName() {
        BasicNameFormatDefiner basicNameFormatDefiner = new BasicNameFormatDefiner();
        Text name = basicNameFormatDefiner.defineName("Name:Adam",1);
        assertEquals(basicNameFormatDefiner.nameTextNode,name);
    }
}
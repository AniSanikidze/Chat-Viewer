package sample;

import javafx.scene.text.Text;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicTimeFormatDefinerTest {

    @Test
    public void defineTime() {
        BasicTimeFormatDefiner basicTimeFormatDefiner = new BasicTimeFormatDefiner();
        Text time = basicTimeFormatDefiner.defineTime("Time:12:34:56",1);

        assertEquals(time,basicTimeFormatDefiner.timeTextNode);
    }
}
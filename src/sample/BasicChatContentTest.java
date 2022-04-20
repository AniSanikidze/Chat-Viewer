package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicChatContentTest {
    BasicChatContent basicChatContent = new BasicChatContent();

    @Test
    public void lineIsNotEmpty() {
        boolean lineIsNotEmpty = basicChatContent.lineIsNotEmpty("Time:12:34:56");
        assertEquals(true, lineIsNotEmpty);
    }

    @Test
    public void keywordNotFound() {
        boolean keywordNotFound = basicChatContent.keywordNotFound(true,1);
        assertEquals(false,keywordNotFound);
    }

    @Test
    public void checkAndDefineLineFormat() {
        assertEquals("Adam",
                basicChatContent.checkAndDefineLineFormat("Name:Adam",1,"Name"));
    }
}
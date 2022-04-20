package sample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;


import static org.junit.Assert.*;

public class CheckFileExtensionTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void checkExtension() {
        CheckFileExtension checkFileExtension = new CheckFileExtension();
        File temporaryFile = null;
        try {
            temporaryFile = folder.newFile("test.msg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(".msg",checkFileExtension.checkExtension(temporaryFile));
    }
}
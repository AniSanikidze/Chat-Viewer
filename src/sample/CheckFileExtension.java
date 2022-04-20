package sample;

import java.io.File;

public class CheckFileExtension {
    /**
     * Cuts and returns the file extension from Filepath
     * @param file Chosen file
     * @return String extension
     */
    String checkExtension (File file) {
        String extension = "";
        String fileName = file.getAbsolutePath();

        int i = fileName.lastIndexOf('.');
        int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

        if (i > p) {
            extension = fileName.substring(i);
        }

        return extension;
    }
}

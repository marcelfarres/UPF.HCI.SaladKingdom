package example.nightfall_of_the_final_conquer.app.util;

import android.content.Context;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;

/**
 * Created by Arnau on 27/05/2014.
 */
public class FileManager {

    public static String openFile(String filePath) {
        File file = new File(filePath);
        InputStream in = null;
        String text = "";
        try {
            in = new BufferedInputStream(new FileInputStream(file), 8192);
            in.read(text.getBytes());

            return text;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}


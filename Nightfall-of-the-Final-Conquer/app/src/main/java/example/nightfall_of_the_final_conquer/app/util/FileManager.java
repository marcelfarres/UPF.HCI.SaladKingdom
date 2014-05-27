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

    public static void openFile() {
        File file = new File("/assets/files/database_sql_create.sql");
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            //TODO
        } catch (FileNotFoundException e) {
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
    }
}
}

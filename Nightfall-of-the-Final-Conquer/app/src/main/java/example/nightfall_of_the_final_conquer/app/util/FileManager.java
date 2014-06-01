package example.nightfall_of_the_final_conquer.app.util;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import example.nightfall_of_the_final_conquer.app.R;

/**
 * Created by Arnau on 27/05/2014.
 */
public class FileManager {

    public static Context context;

    public void setContext(Context context){
        this.context = context;
    }

    public static String openFile(String filePath) {
        try
        {
            InputStream fraw =
                    context.getResources().openRawResource(R.raw.prueba_raw);

            BufferedReader brin =
                    new BufferedReader(new InputStreamReader(fraw));

            String linea = brin.readLine();

            fraw.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
        }

        /*File file = new File(filePath);
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
        return null;*/
    }
}


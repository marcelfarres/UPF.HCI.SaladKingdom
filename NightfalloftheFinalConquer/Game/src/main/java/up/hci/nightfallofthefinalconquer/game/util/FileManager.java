package up.hci.nightfallofthefinalconquer.game.util;

import android.content.Context;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import up.hci.nightfallofthefinalconquer.game.R;

/**
 * Created by Arnau on 27/05/2014.
 */
public class FileManager {

    static public Context context;

    public static void setContext(Context context){
        FileManager.context = context;
    }

    public static String openSQLFile() {
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            InputStream fraw =
                    context.getResources().openRawResource(R.raw.database_sql_create);
            Log.d("Ficheros", "Fichero abierto");

            BufferedReader brin =
                    new BufferedReader(new InputStreamReader(fraw));
            Log.d("Ficheros", "Buffer open");

            while ((line = brin.readLine()) != null) {
                sb.append(line);
            }

            fraw.close();
            Log.d("Ficheros", "Buffer closed!");
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
        }
        Log.d("DB File", sb.toString());
        return sb.toString();
    }
}


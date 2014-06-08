package up.hci.nightfallofthefinalconquer.game.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Arnau on 27/05/2014.
 */
public class NFCSQLiteHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    public NFCSQLiteHelper(Context context, String name, CursorFactory cursorFactory, int version) {
        super(context, name, cursorFactory, version);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(FileManager.openSQLFile());
        createDatabase(db);

        Log.d("DBNFC", "Database created!");

        db.execSQL("INSERT INTO User (id, email, name) VALUES (1, 'naulacambra@gmail.com', 'Arnau')");
        Log.d("DBNFC", "Player inserted!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int previousVersion, int newVersion) {
    }

    //new functions
    public void setDBReadable() {
        this.db = this.getReadableDatabase();
    }

    public void setDBWritable() {
        this.db = this.getWritableDatabase();
    }

    public String getPlayerName() {
        //Log.d("DBNFC", "Setting database readable");
        //setDBReadable();
        Log.d("DBNFC", "Trying to get player name");
        if (db == null) {
            Log.d("DBNFC", "Database is null");
            setDBReadable();
            Log.d("DBNFC", "Setting database readable");
        }
        if (db.isReadOnly()) {
            Log.d("DBNFC", "Is Readable: true");
        } else {
            Log.d("DBNFC", "Is Readable: false");
        }
        Cursor c = db.rawQuery("SELECT name FROM User", new String[]{});
        if (c.moveToFirst()) {
            return c.getString(c.getColumnIndex("name"));
        }
        return "";
    }

    public void createDatabase(SQLiteDatabase db){
        db.execSQL("CREATE TABLE UserUser (\n" +
                "    id int NOT NULL PRIMARY KEY,\n" +
                "    email varchar(100) NOT NULL,\n" +
                "    name varchar(100) NOT NULL\n" +
                ");");
    }
}

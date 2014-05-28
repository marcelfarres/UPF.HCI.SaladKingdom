package example.nightfall_of_the_final_conquer.app.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Arnau on 27/05/2014.
 */
public class NFCSQLiteHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    public NFCSQLiteHelper(Context context, String name, CursorFactory cursorFactory, int version){
        super(context, name, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        this.db = db;
        db.execSQL(FileManager.openFile("./assets/files/database_sql_create.sql"));

        db.execSQL("INSERT INTO User (id, email, name) VALUES (1, 'naulacambra@gmail.com', 'Arnau')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int previousVersion, int newVersion){

    }

    //new functions
    public String getPlayerName(){
        Cursor c = db.rawQuery("SELECT name FROM User", null);
        c.moveToFirst();
        return c.getString(0);
    }
}

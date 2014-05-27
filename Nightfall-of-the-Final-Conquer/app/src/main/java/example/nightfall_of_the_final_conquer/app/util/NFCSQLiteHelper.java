package example.nightfall_of_the_final_conquer.app.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Arnau on 27/05/2014.
 */
public class NFCSQLiteHelper extends SQLiteOpenHelper {

    String sqlCreate = "";

    public NFCSQLiteHelper(Context context, String name, CursorFactory cursorFactory, int version){
        super(context, name, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int previousVersion, int newVersion){

    }
}

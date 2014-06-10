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
        dropDatabase(db);
        createDatabase(db);

        Log.d("DBNFC", "Database created!");

        db.execSQL("INSERT INTO User (id, email, name) VALUES (1, 'naulacambra@gmail.com', 'Arnau')");
        Log.d("DBNFC", "Player inserted!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int previousVersion, int newVersion) {
        dropDatabase(db);
        createDatabase(db);
    }

    //new functions
    public void setDBReadable() {
        this.db = this.getReadableDatabase();
    }

    public void setDBWritable() {
        this.db = this.getWritableDatabase();
    }

    public Cursor query(String query) {
        return db.rawQuery(query, null);
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

    public void dropDatabase(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS User;");
        db.execSQL("DROP TABLE IF EXISTS Stats;");
        db.execSQL("DROP TABLE IF EXISTS Geolocation;");
        db.execSQL("DROP TABLE IF EXISTS Entity;");
        db.execSQL("DROP TABLE IF EXISTS MonsterStatus;");
        db.execSQL("DROP TABLE IF EXISTS Monster;");
    }

    public void createDatabase(SQLiteDatabase db) {
        //User table
        db.execSQL("CREATE TABLE User (\n" +
                "    id int NOT NULL PRIMARY KEY,\n" +
                "    email varchar(100) NOT NULL,\n" +
                "    name varchar(100) NOT NULL\n" +
                ");");
        //Stats Table
        db.execSQL("CREATE TABLE Stats (\n" +
                "    id integer NOT NULL PRIMARY KEY,\n" +
                "    hp integer NOT NULL,\n" +
                "    mp integer NOT NULL,\n" +
                "    strength integer NOT NULL,\n" +
                "    defense integer NOT NULL,\n" +
                "    magic_defense integer NOT NULL,\n" +
                "    speed integer NOT NULL,\n" +
                "    level integer NOT NULL\n" +
                ");");
        //Geolocations Table
        db.execSQL("CREATE TABLE Geolocation (\n" +
                "    id integer NOT NULL PRIMARY KEY,\n" +
                "    latitude double NOT NULL,\n" +
                "    longitude double NOT NULL,\n" +
                "    Geolocations_id integer NOT NULL\n" +
                ");");
        //Entity Table
        db.execSQL("CREATE TABLE Entity (\n" +
                "    id integer NOT NULL PRIMARY KEY,\n" +
                "    name varchar(100) NOT NULL,\n" +
                "    id_stats integer NOT NULL,\n" +
                "    id_geolocation integer NOT NULL,\n" +
                "    avatar varchar(100),\n" +
                "    FOREIGN KEY (id_geolocation) REFERENCES Geolocations (id),\n" +
                "    FOREIGN KEY (id_stats) REFERENCES Stats (id)\n" +
                ");");
        //Status Monster Table
        db.execSQL("CREATE TABLE MonsterStatus (\n" +
                "    id integer NOT NULL PRIMARY KEY,\n" +
                "    status varchar(100) NOT NULL\n" +
                ");");
        addMonsterStatus(db);
        //Monsters Table
        db.execSQL("CREATE TABLE Monster (\n" +
                "    id integer NOT NULL PRIMARY KEY,\n" +
                "    id_status integer NOT NULL,\n" +
                "    id_entity integer NOT NULL,\n" +
                "    FOREIGN KEY (id_status) REFERENCES MonsterStatus (id),\n" +
                "    FOREIGN KEY (id_entity) REFERENCES Entity (id)\n" +
                ");");
        addMonsters(db, 10);
    }

    public void addMonsterStatus(SQLiteDatabase db) {
        db.execSQL("INSERT INTO MonsterStatus " +
                "VALUES (" +
                "1," +
                "'Non seen');");
        db.execSQL("INSERT INTO MonsterStatus " +
                "VALUES (" +
                "2," +
                "'Seen and non defeated');");
        db.execSQL("INSERT INTO MonsterStatus " +
                "VALUES (" +
                "3," +
                "'Seen and defeated');");
    }

    public void addMonsters(SQLiteDatabase db, int quantity) {
        String[] names = {"Molbol", "Behemot", "Ahriman", "Jahi", "Ente Rojo", "Agamido", "Halcon", "Nitro", "Lupus", "Ochu", "Sahuagin", "Rocomaimai", "Yaibal"};
        for(int i=1; i <= quantity; i++){
            //add stats monster
            db.execSQL("INSERT INTO Stats " +
                    "VALUES (" +
                    i + "," +
                    (Math.random()*200 + 300) + "," +
                    (Math.random()*200 + 50) + "," +
                    (Math.random()*25 + 25) + "," +
                    (Math.random()*25 + 25) + "," +
                    (Math.random()*15 + 10) + "," +
                    (Math.random()*5 + 5) + "," +
                    (Math.random()*50 + 50) + "" +
                    ");");
            //add entity Monster
            db.execSQL("INSERT INTO Entity " +
                    "VALUES (" +
                    i + "," +
                    "'" + names[i%names.length] + "'," +
                    i +"," +
                    "1," +
                    "null" +
                    ");");
            //add monster
            db.execSQL("INSERT INTO Monster " +
                    "VALUES (" +
                    i + "," +
                    (int)(Math.random()*3) + "," +
                    i +
                    ");");
        }
    }
}

package up.hci.nightfallofthefinalconquer.game.managers;

import android.database.Cursor;

import java.util.ArrayList;

import up.hci.nightfallofthefinalconquer.game.classes.Monster;
import up.hci.nightfallofthefinalconquer.game.util.NFCSQLiteHelper;

/**
 * Created by pacific on 10/06/2014.
 */
public class MonsterManager {
    public NFCSQLiteHelper nfchp;
    public ArrayList<Monster> monsters;

    private static MonsterManager INSTANCE = null;

    private MonsterManager() {
        monsters = new ArrayList<Monster>();
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MonsterManager();
        }
    }

    public static MonsterManager getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

    public void updateMonsterList() {
        Cursor c = nfchp.query("SELECT name, hp, mp, strength, defense, magic_defense, speed, level FROM Monster m, Entity e, Stats s WHERE m.id_status = s.id AND m.id_entity = e.id");
        if (c.moveToFirst()) {
            do {
                String name = c.getString(0);
                int hp = c.getInt(1);
                int mp = c.getInt(2);
                int stg = c.getInt(3);
                int def = c.getInt(4);
                int mdef = c.getInt(4);
                int spd = c.getInt(5);
                int lvl = c.getInt(6);

                monsters.add(new Monster(name, hp, mp, stg, def, mdef, spd, lvl));
            } while (c.moveToNext());
        }
    }

    public ArrayList<Monster> getMonsters() {
        if (monsters.size() == 0)
            updateMonsterList();
        return monsters;
    }

}

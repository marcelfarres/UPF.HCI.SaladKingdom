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
        Cursor c = nfchp.query("SELECT m.id, name, hp, mp, strength, defense, magic_defense, speed, level FROM Monster m, Entity e, Stats s WHERE m.id_entity = e.id AND e.id_stats = s.id");
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                String name = c.getString(1);
                int hp = c.getInt(2);
                int mp = c.getInt(3);
                int stg = c.getInt(4);
                int def = c.getInt(5);
                int mdef = c.getInt(6);
                int spd = c.getInt(7);
                int lvl = c.getInt(8);

                monsters.add(new Monster(id, name, hp, mp, stg, def, mdef, spd, lvl));
            } while (c.moveToNext());
        }
    }

    public ArrayList<Monster> getMonsters() {
        if (monsters.size() == 0)
            updateMonsterList();
        return monsters;
    }

    public Monster getMonster( int idMonster ){
        if (monsters.size() == 0)
            updateMonsterList();
        for(Monster monster : monsters){
            if(monster.getId() == idMonster)
                return monster;
        }
        return null;
    }

    public ArrayList<Monster> getMonsters(boolean seen, boolean defeated) {
        ArrayList<Monster> nMonsters = new ArrayList<Monster>();

        if (monsters.size() == 0)
            updateMonsterList();

        for(Monster monster : monsters){
            if(seen && defeated){
                if(monster.isSeen() && monster.isDefeated()){
                    nMonsters.add(monster);
                }
            }else if(seen && !defeated){
                if(monster.isSeen()){
                    nMonsters.add(monster);
                }
            }else{
                nMonsters.add(monster);
            }
        }
        return nMonsters;
    }
}

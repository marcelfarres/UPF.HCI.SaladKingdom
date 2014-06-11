package up.hci.nightfallofthefinalconquer.game.classes;

/**
 * Created by pacific on 11/06/2014.
 */
public class Item {
    int id;
    String name;
    Stats stats;

    Item(int id){
        this.id = id;
        name = "";
        stats = null;
    }

    Item(int id, String name){
        this.id = id;
        this.name = name;
        stats = null;
    }

    Item(int id, String name, int hp, int mp, int stg, int def, int mdef, int spd, int lvl){
        this.id = id;
        this.name = name;
        stats = new Stats(hp, mp, stg, def, mdef, spd, lvl);
    }

    
}

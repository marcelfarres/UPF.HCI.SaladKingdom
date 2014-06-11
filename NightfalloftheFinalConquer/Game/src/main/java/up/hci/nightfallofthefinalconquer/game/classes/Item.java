package up.hci.nightfallofthefinalconquer.game.classes;

/**
 * Created by pacific on 11/06/2014.
 */
public class Item {
    int id;
    String name;
    Stats stats;

    public Item(int id) {
        this.id = id;
        name = "";
        stats = null;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
        stats = null;
    }

    public Item(int id, String name, int hp, int mp, int stg, int def, int mdef, int spd, int lvl) {
        this.id = id;
        this.name = name;
        stats = new Stats(hp, mp, stg, def, mdef, spd, lvl);
    }

    public String getName() {
        return this.name;
    }

    public Stats getStats() {
        return this.stats;
    }

    public int getId() {
        return this.id;
    }

    public boolean isOwned(){
        return true;
    }

    public boolean isEquipped(){
        return true;
    }
}

package up.hci.nightfallofthefinalconquer.game.classes;

/**
 * Created by pacific on 10/06/2014.
 */
public class Monster {
    String name;
    Stats stats;

    public Monster(){
        name = "";
        stats = new Stats();
    }

    public Monster(String name){
        this.name = name;
        stats = new Stats();
    }

    public Monster(String name, int hp, int mp, int stg, int def, int mdef, int spd, int lvl){
        this.name = name;
        stats = new Stats(hp, mp, stg, def, mdef, spd, lvl);
    }

    public String getName(){
        return this.name;
    }

    public Stats getStats(){
        return this.stats;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStats(Stats stats){
        this.stats = stats;
    }
}

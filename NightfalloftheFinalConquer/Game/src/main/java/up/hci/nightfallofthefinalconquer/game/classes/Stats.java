package up.hci.nightfallofthefinalconquer.game.classes;

/**
 * Created by pacific on 10/06/2014.
 */
public class Stats {
    int hp;
    int mp;
    int stg;
    int def;
    int mdef;
    int spd;
    int lvl;

    Stats(){
        hp = mp = stg = def = mdef = spd = lvl = 0;
    }

    Stats(int hp, int mp, int stg, int def, int mdef, int spd, int lvl){
        this.hp = hp;
        this.mp = mp;
        this.def = def;
        this.mdef = mdef;
        this.spd = spd;
        this.lvl = lvl;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getStg() {
        return stg;
    }

    public int getDef() {
        return def;
    }

    public int getMdef() {
        return mdef;
    }

    public int getSpd() {
        return spd;
    }

    public int getLvl() {
        return lvl;
    }
}

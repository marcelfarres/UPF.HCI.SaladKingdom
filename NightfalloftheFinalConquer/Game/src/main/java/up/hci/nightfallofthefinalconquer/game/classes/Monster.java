package up.hci.nightfallofthefinalconquer.game.classes;

/**
 * Created by pacific on 10/06/2014.
 */
enum MonsterStatus {
    NON_SEEN("Non seen", 1),
    SEEN_NON_DEFEATED("Seen and non defeated", 2),
    SEEN_DEFEATED("Seen and defeated", 3);

    private String stringValue;
    private int intValue;

    private MonsterStatus(String toString, int value) {
        stringValue = toString;
        intValue = value;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}

public class Monster {
    int id;
    String name;
    Stats stats;
    MonsterStatus mStatus;

    public Monster(int id) {
        this.id = id;
        name = "";
        stats = new Stats();
    }

    public Monster(int id, String name) {
        this.id = id;
        this.name = name;
        stats = new Stats();
        mStatus = MonsterStatus.NON_SEEN;
    }

    public Monster(int id, String name, int hp, int mp, int stg, int def, int mdef, int spd, int lvl) {
        this.id = id;
        this.name = name;
        stats = new Stats(hp, mp, stg, def, mdef, spd, lvl);
        mStatus = MonsterStatus.NON_SEEN;
    }

    public Monster(int id, String name, int hp, int mp, int stg, int def, int mdef, int spd, int lvl, int status) {
        this.id = id;
        this.name = name;
        stats = new Stats(hp, mp, stg, def, mdef, spd, lvl);
        switch (status) {
            case 0:
                mStatus = MonsterStatus.NON_SEEN;
                break;
            case 1:
                mStatus = MonsterStatus.SEEN_NON_DEFEATED;
                break;
            case 2:
                mStatus = MonsterStatus.SEEN_DEFEATED;
        }
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

    public String getStatus(){
        return this.mStatus.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public boolean isSeen() {
        if (mStatus == MonsterStatus.SEEN_DEFEATED || mStatus == MonsterStatus.SEEN_NON_DEFEATED)
            return true;
        return false;
    }

    public boolean isDefeated() {
        if (mStatus == MonsterStatus.SEEN_DEFEATED)
            return true;
        return false;
    }
}

package up.hci.nightfallofthefinalconquer.game.managers;

import android.database.Cursor;

import java.util.ArrayList;

import up.hci.nightfallofthefinalconquer.game.classes.Item;
import up.hci.nightfallofthefinalconquer.game.classes.Monster;
import up.hci.nightfallofthefinalconquer.game.util.NFCSQLiteHelper;

/**
 * Created by pacific on 10/06/2014.
 */
public class ItemManager {
    public NFCSQLiteHelper nfchp;
    public ArrayList<Item> items;

    private static ItemManager INSTANCE = null;

    private ItemManager() {
        items = new ArrayList<Item>();
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ItemManager();
        }
    }

    public static ItemManager getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

    public void updateItemList() {
        Cursor c = nfchp.query("SELECT eq.id, name, hp, mp, strength, defense, magic_defense, speed, level, own, equipped FROM Equipment eq, Entity e, Stats s WHERE eq.id_entity = e.id AND e.id_stats = s.id");
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

                items.add(new Item(id, name, hp, mp, stg, def, mdef, spd, lvl));
            } while (c.moveToNext());
        }
    }

    public ArrayList<Item> getItems() {
        if (items.size() == 0)
            updateItemList();
        return items;
    }

    public Item getItem( int idItem ){
        if (items.size() == 0)
            updateItemList();
        for(Item item : items){
            if(item.getId() == idItem)
                return item;
        }
        return null;
    }

    public ArrayList<Item> getItems(boolean own, boolean equipped) {
        ArrayList<Item> nItems = new ArrayList<Item>();

        if (items.size() == 0)
            updateItemList();

        for(Item item : items){
            if(own && equipped){
                if(item.isOwned() && item.isEquipped()){
                    nItems.add(item);
                }
            }else if(own && !equipped){
                if(item.isOwned()){
                    nItems.add(item);
                }
            }else{
                nItems.add(item);
            }
        }
        return nItems;
    }
}

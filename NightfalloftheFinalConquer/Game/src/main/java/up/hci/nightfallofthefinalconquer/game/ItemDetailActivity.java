package up.hci.nightfallofthefinalconquer.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import up.hci.nightfallofthefinalconquer.game.adapters.MonsterItemAdapter;
import up.hci.nightfallofthefinalconquer.game.classes.Item;
import up.hci.nightfallofthefinalconquer.game.classes.Monster;
import up.hci.nightfallofthefinalconquer.game.managers.ItemManager;
import up.hci.nightfallofthefinalconquer.game.managers.MonsterManager;

/**
 * Created by pacific on 11/06/2014.
 */
public class ItemDetailActivity extends Activity {
    ListView listview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        setToolbarButtons();

        Bundle bundle = this.getIntent().getExtras();
        int itemId = bundle.getInt("ItemId");

        Item item = ItemManager.getInstance().getItem(itemId);

        TextView item_name = (TextView) findViewById(R.id.item_name);
        item_name.setText( item.getName() );

        TextView item_hp = (TextView) findViewById(R.id.HP_value);
        item_hp.setText( String.valueOf(item.getStats().getHp()) );

        TextView item_mp = (TextView) findViewById(R.id.MP_value);
        item_mp.setText( String.valueOf(item.getStats().getMp()) );

        TextView item_stg = (TextView) findViewById(R.id.ATK_value);
        item_stg.setText( String.valueOf(item.getStats().getStg()) );

        TextView item_spd = (TextView) findViewById(R.id.SP_value);
        item_spd.setText( String.valueOf(item.getStats().getSpd()) );

        TextView item_def = (TextView) findViewById(R.id.DEF_value);
        item_def.setText( String.valueOf(item.getStats().getDef()) );



//        TextView monster_hp = (TextView) findViewById(R.id.HP_value_monster);
//        monster_hp.setText( monster.getStats().getHp() );

        /*TextView total_monsters = (TextView) findViewById(R.id.number_total_monsters);
        total_monsters.setText(monsterList.size());*/
    }


    /*NEW FUNCTIONS*/
    public void setToolbarButtons() {
        //clicar al boto item del toolbar
        (findViewById(R.id.button_item)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToolbarActivity(ItemListActivity.class);
            }
        });

        //clicar al boto log del toolbar
        (findViewById(R.id.button_log)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToolbarActivity(LogActivity.class);
            }
        });

        //clicar al boto map del toolbar
        (findViewById(R.id.button_map)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToolbarActivity(MapActivity.class);
            }
        });

        //clicar al boto monsters del toolbar
        (findViewById(R.id.button_monsters)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToolbarActivity(MonstersListActivity.class);
            }
        });
    }

    public void startToolbarActivity(java.lang.Class<?> cls) {
        Intent i = new Intent(this, cls);
        startActivity(i);
    }
}

package up.hci.nightfallofthefinalconquer.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import up.hci.nightfallofthefinalconquer.game.adapters.MonsterItemAdapter;
import up.hci.nightfallofthefinalconquer.game.classes.Monster;
import up.hci.nightfallofthefinalconquer.game.managers.MonsterManager;

/**
 * Created by pacific on 11/06/2014.
 */
public class MonsterDetailActivity extends Activity {
    ListView listview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monster_detail);

        setToolbarButtons();

        Bundle bundle = this.getIntent().getExtras();
        int monsterId = bundle.getInt("MonsterId");

        Monster monster = MonsterManager.getInstance().getMonster( monsterId );

        TextView monster_name = (TextView) findViewById(R.id.name_monster);
        monster_name.setText( monster.getName() );

        TextView monster_status = (TextView) findViewById(R.id.defeated_or_not);
        monster_status.setText( monster.getStatus() );

        TextView monster_hp = (TextView) findViewById(R.id.HP_value_monster);
        monster_hp.setText( String.valueOf(monster.getStats().getHp()) );

        TextView monster_mp = (TextView) findViewById(R.id.MP_value_monster);
        monster_mp.setText( String.valueOf(monster.getStats().getMp()) );

        TextView monster_stg = (TextView) findViewById(R.id.ATK_value_monster);
        monster_stg.setText( String.valueOf(monster.getStats().getStg()) );

        TextView monster_spd = (TextView) findViewById(R.id.SP_value_monster);
        monster_spd.setText( String.valueOf(monster.getStats().getSpd()) );

        TextView monster_def = (TextView) findViewById(R.id.DEF_value_monster);
        monster_def.setText( String.valueOf(monster.getStats().getDef()) );

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
                startToolbarActivity(ItemsActivity.class);
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

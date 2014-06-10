package up.hci.nightfallofthefinalconquer.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import up.hci.nightfallofthefinalconquer.game.adapters.MonsterItemAdapter;
import up.hci.nightfallofthefinalconquer.game.classes.Monster;
import up.hci.nightfallofthefinalconquer.game.managers.MonsterManager;

/**
 * Created by desire on 05/06/2014.
 */
public class MonstersListActivity extends Activity {

    private Button button_item;
    private Button button_log;
    private Button button_maps;
    private Button button_monsters;
    ListView listview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monster_list);

        setToolbarButtons();

        listview = (ListView) findViewById(R.id.list_monsters);

        ArrayList<Monster> monsterList = MonsterManager.getInstance().getMonsters();

        listview.setAdapter(new MonsterItemAdapter(this, monsterList));
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
        /*(findViewById(R.id.button_item)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startToolbarActivity(LogActivity.class);
            }
        });*/

        //clicar al boto monsters del toolbar
//        (findViewById(R.id.button_monsters)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startToolbarActivity(MonstersListActivity.class);
//            }
//        });
    }

    public void startToolbarActivity(java.lang.Class<?> cls) {
        Intent i = new Intent(this, cls);
        startActivity(i);
    }
}
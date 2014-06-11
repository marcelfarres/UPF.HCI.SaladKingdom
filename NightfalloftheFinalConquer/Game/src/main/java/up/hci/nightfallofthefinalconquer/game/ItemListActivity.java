package up.hci.nightfallofthefinalconquer.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import up.hci.nightfallofthefinalconquer.game.adapters.ItemItemAdapter;
import up.hci.nightfallofthefinalconquer.game.adapters.MonsterItemAdapter;
import up.hci.nightfallofthefinalconquer.game.classes.Item;
import up.hci.nightfallofthefinalconquer.game.classes.Monster;
import up.hci.nightfallofthefinalconquer.game.managers.ItemManager;
import up.hci.nightfallofthefinalconquer.game.managers.MonsterManager;

/**
 * Created by desire on 05/06/2014.
 */
public class ItemListActivity extends Activity {

    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list);

        setToolbarButtons();

        listview = (ListView) findViewById(R.id.list_items);

        ArrayList<Item> itemList = ItemManager.getInstance().getItems();
        listview.setAdapter(new ItemItemAdapter(this, itemList));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView id = (TextView) view.findViewById(R.id.itemItemId);

                Bundle b = new Bundle();
                b.putInt("ItemId", Integer.valueOf(id.getText().toString()) );
                startToolbarActivity(ItemDetailActivity.class, b);
            }
        });
    }

    /*NEW FUNCTIONS*/
    public void setToolbarButtons() {
        //clicar al boto item del toolbar
//        (findViewById(R.id.button_item)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startToolbarActivity(ItemsActivity.class);
//            }
//        });

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

//        clicar al boto monsters del toolbar
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

    public void startToolbarActivity(java.lang.Class<?> cls, Bundle bundle) {
        Intent i = new Intent(this, cls);
        i.putExtras(bundle);
        startActivity(i);
    }
}

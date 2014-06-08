package up.hci.nightfallofthefinalconquer.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by desire on 05/06/2014.
 */
public class LogActivity extends Activity {

    private Button button_item;
    private Button button_log;
    private Button button_maps;
    private Button button_monsters;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_zones);

        //addListenerOnButton();

        //clicar al boto item del toolbar
        View.OnClickListener listnr_items = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("ItemsActivity");
                startActivity(i);
            }
        };
        Button butt_items = (Button) findViewById(R.id.button_item);
        butt_items.setOnClickListener(listnr_items);

        //clicar al boto map del toolbar
        View.OnClickListener listnr_map = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("MapActivity");
                startActivity(i);
            }
        };
        Button butt_map = (Button) findViewById(R.id.button_map);
        butt_map.setOnClickListener(listnr_map);

        //clicar al boto monsters del toolbar
        View.OnClickListener listnr_mons = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("MonstersActivity");
                startActivity(i);
            }
        };
        Button butt_monsters = (Button) findViewById(R.id.button_monsters);
        butt_monsters.setOnClickListener(listnr_mons);
    }

    public void addListenerOnButton() {

        button_item = (Button) findViewById(R.id.button_item);
        button_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        button_log = (Button) findViewById(R.id.button_log);
        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        button_maps = (Button) findViewById(R.id.button_map);
        button_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        button_monsters = (Button) findViewById(R.id.button_monsters);
        button_monsters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

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
                startToolbarActivity(main.class);
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

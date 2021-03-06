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
        setContentView(R.layout.log_list);

        setToolbarButtons();
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
//        (findViewById(R.id.button_log)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startToolbarActivity(main.class);
//            }
//        });
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

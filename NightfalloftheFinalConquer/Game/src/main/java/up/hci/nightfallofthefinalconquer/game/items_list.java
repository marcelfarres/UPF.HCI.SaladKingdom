package up.hci.nightfallofthefinalconquer.game;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by desire on 05/06/2014.
 */
public class items_list extends Activity {

    private ListView list_items;
    private Button button_item;
    private Button button_log;
    private Button button_maps;
    private Button button_monsters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);

        addListenerOnListView();

    }

    public void addListenerOnListView() {

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
}

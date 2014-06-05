package up.hci.nightfallofthefinalconquer.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by desire on 05/06/2014.
 */
public class log_zones extends Activity {

    private Button button_item;
    private Button button_log;
    private Button button_maps;
    private Button button_monsters;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_zones);

        addListenerOnButton();
    }

    public void addListenerOnButton(){

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

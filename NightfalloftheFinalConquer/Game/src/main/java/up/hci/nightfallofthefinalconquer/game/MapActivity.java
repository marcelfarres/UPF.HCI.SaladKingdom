package up.hci.nightfallofthefinalconquer.game;

/**
 * Created by Roser on 11/06/2014.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MapActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
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

//        clicar al boto log del toolbar
        (findViewById(R.id.button_log)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToolbarActivity(LogActivity.class);
            }
        });
        //clicar al boto map del toolbar
//        (findViewById(R.id.button_map)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startToolbarActivity(MapActivity.class);
//            }
//        });

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

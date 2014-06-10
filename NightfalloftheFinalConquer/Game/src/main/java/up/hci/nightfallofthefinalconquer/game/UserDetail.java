package up.hci.nightfallofthefinalconquer.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by desire on 05/06/2014.
 */
public class UserDetail extends Activity {

    private Button hp_minus;
    private Button hp_plus;

    private Button mp_minus;
    private Button mp_plus;

    private Button atk_minus;
    private Button atk_plus;

    private Button def_minus;
    private Button def_plus;

    private Button sp_minus;
    private Button sp_plus;

    private Button button_item;
    private Button button_log;
    private Button button_maps;
    private Button button_monsters;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_user_detail);

        addListenerOnButton();
    }

    public void addListenerOnButton(){

        hp_minus = (Button) findViewById(R.id.hp_minus);
        hp_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        hp_plus = (Button) findViewById(R.id.hp_plus);
        hp_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        mp_minus = (Button) findViewById(R.id.mp_minus);
        mp_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        mp_plus = (Button) findViewById(R.id.mp_plus);
        mp_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        atk_minus = (Button) findViewById(R.id.atk_minus);
        atk_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        atk_plus = (Button) findViewById(R.id.atk_plus);
        atk_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        def_minus = (Button) findViewById(R.id.def_minus);
        def_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        def_plus = (Button) findViewById(R.id.def_plus);
        def_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        sp_minus = (Button) findViewById(R.id.sp_minus);
        sp_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

        sp_plus = (Button) findViewById(R.id.sp_plus);
        sp_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });

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

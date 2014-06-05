package up.hci.nightfallofthefinalconquer.game;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by desire on 05/06/2014.
 */
public class items_list_object extends Activity {

    private Button button_team;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list_object);

        addListenerOnButton();

    }

    public void addListenerOnButton(){

        button_team = (Button) findViewById(R.id.button_team);
        button_team.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION !!!! (Implementar !)
            }
        });
    }



}

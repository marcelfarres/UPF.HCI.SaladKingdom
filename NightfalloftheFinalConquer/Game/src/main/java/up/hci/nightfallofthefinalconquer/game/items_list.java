package up.hci.nightfallofthefinalconquer.game;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by desire on 05/06/2014.
 */
public class items_list extends Activity {

    private ListView list_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);

        addListenerOnListView();

    }

    public void addListenerOnListView() {

    }
}

package up.hci.nightfallofthefinalconquer.game.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import up.hci.nightfallofthefinalconquer.game.R;
import up.hci.nightfallofthefinalconquer.game.classes.Item;

/**
 * Created by pacific on 10/06/2014.
 */
public class ItemItemAdapter extends BaseAdapter {
    Context context;
    ArrayList<Item> data;
    private static LayoutInflater inflater = null;

    public ItemItemAdapter(Context context, ArrayList<Item> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.item_list_item, null);
        TextView name = (TextView) vi.findViewById(R.id.itemItemName);
        TextView lvl = (TextView) vi.findViewById(R.id.itemItemLevel);
        TextView id = (TextView) vi.findViewById(R.id.itemItemId);
        name.setText(data.get(position).getName());
        lvl.setText("Level:" + String.valueOf(data.get(position).getStats().getLvl()));
        id.setText(String.valueOf(data.get(position).getId()));
        return vi;
    }
}

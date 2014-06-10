package up.hci.nightfallofthefinalconquer.game.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import up.hci.nightfallofthefinalconquer.game.R;
import up.hci.nightfallofthefinalconquer.game.classes.Monster;

/**
 * Created by pacific on 08/06/2014.
 */
public class MonsterItemAdapter extends BaseAdapter {
    Context context;
    ArrayList<Monster> data;
    private static LayoutInflater inflater = null;

    public MonsterItemAdapter(Context context, ArrayList<Monster> data) {
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
            vi = inflater.inflate(R.layout.monster_list_item, null);
        TextView name = (TextView) vi.findViewById(R.id.monsterItemName);
        TextView lvl = (TextView) vi.findViewById(R.id.monsterItemLevel);
        name.setText(data.get(position).getName());
        lvl.setText(String.valueOf(data.get(position).getStats().getLvl()));
        return vi;
    }
}

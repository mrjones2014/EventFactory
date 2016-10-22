package eventfactory.app_name;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class HeaderListAdapter<String> extends ArrayAdapter<String> {
    public HeaderListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        if(position == 0){
            view.setBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));
        }
        return view;
    }
}

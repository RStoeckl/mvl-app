package at.mvl.musikvereinleopoldsdorf.content.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import at.mvl.musikvereinleopoldsdorf.R;
import at.mvl.mvllib.data.Buch;
import at.mvl.mvllib.data.Buchsammlung;
import at.mvl.mvllib.data.Seite;

/**
 * Created by richi on 14.11.15.
 */
public class StueckAdapter extends BaseExpandableListAdapter {

    Buchsammlung buecher;
    LayoutInflater inflater;

    public StueckAdapter(Buchsammlung buecher, LayoutInflater inflater) {
        this.buecher = buecher;
        this.inflater = inflater;
    }

    @Override
    public int getGroupCount() {
        return buecher.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return buecher.get(groupPosition).getNumbers().size();
    }

    @Override
    public Buch getGroup(int groupPosition) {
        return buecher.get(groupPosition);
    }

    @Override
    public Seite getChild(int groupPosition, int childPosition) {
        return getGroup(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View buchList = inflater.inflate(R.layout.buch_row, parent, false);

        TextView titel = (TextView) buchList.findViewById(R.id.buch_titel);
        titel.setText(getGroup(groupPosition).getName());

        return buchList;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.stueck_row, null);

        Seite seite = getChild(groupPosition, childPosition);

        TextView nummer = (TextView) row.findViewById(R.id.stueck_nummer);
        TextView titel = (TextView) row.findViewById(R.id.stueck_name);

        nummer.setText(""+seite.getNummer());
        titel.setText(seite.getTitel());

        return row;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}

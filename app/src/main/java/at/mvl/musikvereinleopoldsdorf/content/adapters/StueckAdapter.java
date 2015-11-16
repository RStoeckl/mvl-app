package at.mvl.musikvereinleopoldsdorf.content.adapters;

import android.preference.PreferenceManager;
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

    private Buchsammlung buecher;
    private Buchsammlung original;
    private LayoutInflater inflater;

    public StueckAdapter(Buchsammlung buecher, Buchsammlung original, LayoutInflater inflater) {
        this.buecher = buecher;
        this.inflater = inflater;
        this.original = original;
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
        titel.setText(getTitle(getGroup(groupPosition)));

        return buchList;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.stueck_row, null);

        Seite seite = getChild(groupPosition, childPosition);

        TextView nummer = (TextView) row.findViewById(R.id.stueck_nummer);
        TextView titel = (TextView) row.findViewById(R.id.stueck_name);

        nummer.setText("" + seite.getNummer());
        titel.setText(seite.getTitel());

        return row;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private String getTitle(Buch buch) {
        Buch original = searchBook(buch);

        String att = PreferenceManager.getDefaultSharedPreferences(inflater.getContext()).getString("appearance_pageformat", "");
        StringBuilder sb = new StringBuilder();
        char[] attb = att.toCharArray();
        boolean varMode = false;
        for (int i = 0; i < attb.length; i++) {
            char chari = attb[i];
            if (chari == '$') {
                if (varMode)
                    sb.append(chari);
                else
                    varMode = true;
            } else if (varMode) {
                switch (chari) {
                    case 'n': {
                        sb.append(buch.getName());
                        break;
                    }
                    case 'f': {
                        sb.append(buch.size());
                        break;
                    }
                    case 's': {
                        sb.append(original.size());
                        break;
                    }
                    case 'l': {
                        sb.append(original.getLastPage().getNummer());
                        break;
                    }
                }
                varMode=false;
            } else
                sb.append(chari);

        }
        return sb.toString();
    }

    private Buch searchBook(Buch buch) {
        for (Buch b : original)
            if (buch.getId() == b.getId())
                return b;
        return new Buch(0, "");
    }
}

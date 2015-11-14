package at.mvl.musikvereinleopoldsdorf.content.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import at.mvl.musikvereinleopoldsdorf.R;
import at.mvl.mvllib.data.Termin;
import at.mvl.mvllib.tools.Downloader;

/**
 * Created by richi on 06.11.15.
 */
public class TerminAdapter extends BaseAdapter {

    private ArrayList<Termin> termine;
    private LayoutInflater inflater;

    public TerminAdapter(LayoutInflater inflater, ArrayList<Termin> termine) {
        this.termine = termine;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return termine.size();
    }

    @Override
    public Termin getItem(int position) {
        return termine.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.termin_row, parent, false);
        Termin termin = getItem(position);
        TextView name = (TextView) row.findViewById(R.id.termin_name_content);
        name.setText(termin.getName());
        return row;
    }
}

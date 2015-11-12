package at.mvl.musikvereinleopoldsdorf.content.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;

import at.mvl.mvllib.data.Termin;
import at.mvl.mvllib.tools.Downloader;

/**
 * Created by richi on 06.11.15.
 */
public class TerminAdapter extends BaseAdapter {

    private ArrayList<Termin> termine;
    private ContextCompat context;

    @Override
    public int getCount() {
        return termine.size();
    }

    @Override
    public Object getItem(int position) {
        return termine.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

package at.mvl.musikvereinleopoldsdorf.content.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import java.util.ArrayList;

import at.mvl.mvllib.data.Termin;
import at.mvl.mvllib.tools.Downloader;

/**
 * Created by richi on 06.11.15.
 */
public class TerminAdapter implements ListAdapter {

    ArrayList<Termin> termine;

    public TerminAdapter()
    {

    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

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
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return termine.isEmpty();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }
}

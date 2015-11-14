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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

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

        TextView treffpunkt = (TextView) row.findViewById(R.id.termin_treffpunkt_content);
        treffpunkt.setText(termin.getTreffpunkt());

        TextView beginn = (TextView) row.findViewById(R.id.termin_beginn_content);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        beginn.setText(sdf.format(termin.getBeginn().getTime()));

        TextView adjustierung = (TextView) row.findViewById(R.id.termin_adjustierung_content);
        adjustierung.setText(termin.getAdjustierung());

        TextView dauer = (TextView) row.findViewById(R.id.termin_dauer_content);
        dauer.setText(termin.getDauer());

        TextView beschreibung = (TextView) row.findViewById(R.id.termin_beschreibung_content);
        beschreibung.setText(termin.getBeschreibung());

        HashMap<TextView, TextView> fields = new HashMap<>();
        fields.put((TextView) row.findViewById(R.id.termin_treffpunkt_desc), treffpunkt);
        fields.put((TextView) row.findViewById(R.id.termin_adjustierung_desc), adjustierung);
        fields.put((TextView) row.findViewById(R.id.termin_beginn_desc), beginn);
        fields.put((TextView) row.findViewById(R.id.termin_beschreibung_desc), beschreibung);
        fields.put((TextView) row.findViewById(R.id.termin_dauer_desc), dauer);

        for (TextView desc : fields.keySet()) {
            TextView value = fields.get(desc);
            if (value == null)
                desc.setVisibility(View.INVISIBLE);
            else if (value.getText() == null || value.getText().equals("null")) {
                desc.setVisibility(View.INVISIBLE);
                value.setVisibility(View.INVISIBLE);
            }

        }
        return row;
    }
}

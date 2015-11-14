package at.mvl.musikvereinleopoldsdorf.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import at.mvl.musikvereinleopoldsdorf.R;
import at.mvl.musikvereinleopoldsdorf.content.adapters.TerminAdapter;
import at.mvl.mvllib.converter.JsonToTermin;
import at.mvl.mvllib.data.Termin;
import at.mvl.mvllib.tools.Downloader;

/**
 * Created by richi on 02.11.15.
 */
public class TerminFragment extends Fragment {

    private View contentView;
    private ArrayList<Termin> termine;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.termin_layout, null);
        //ListView list = (ListView) contentView.findViewById(R.id.termin_liste);

        termine = JsonToTermin.parseTermine("[\n" +
                "   {\n" +
                "      \"timestamp\" : \"Tue Oct 27 16:48:23 2015\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"beschreibung\" : null,\n" +
                "      \"name\" : \"Allerheiligen\",\n" +
                "      \"adjustierung\" : \"Mantel mit Hut\",\n" +
                "      \"beginn\" : \"2015-11-01 10:45:00\",\n" +
                "      \"treffpunkt\" : \"Feuerwehr\",\n" +
                "      \"id\" : \"1\",\n" +
                "      \"adjid\" : \"4\",\n" +
                "      \"dauer\" : null\n" +
                "   },\n" +
                "   {\n" +
                "      \"beschreibung\" : null,\n" +
                "      \"name\" : \"Adventmarkt\",\n" +
                "      \"adjustierung\" : null,\n" +
                "      \"beginn\" : \"2015-11-21 17:00:00\",\n" +
                "      \"treffpunkt\" : \"Schubertpark\",\n" +
                "      \"id\" : \"2\",\n" +
                "      \"adjid\" : null,\n" +
                "      \"dauer\" : null\n" +
                "   },\n" +
                "   {\n" +
                "      \"beschreibung\" : null,\n" +
                "      \"name\" : \"Krampuskonzert\",\n" +
                "      \"adjustierung\" : \"Uniform ohne Hut\",\n" +
                "      \"beginn\" : \"2015-12-05 18:00:00\",\n" +
                "      \"treffpunkt\" : \"Gasthaus List\",\n" +
                "      \"id\" : \"3\",\n" +
                "      \"adjid\" : \"1\",\n" +
                "      \"dauer\" : null\n" +
                "   },\n" +
                "   {\n" +
                "      \"beschreibung\" : null,\n" +
                "      \"name\" : \"Turmblasen\",\n" +
                "      \"adjustierung\" : \"Mantel mit Hut\",\n" +
                "      \"beginn\" : \"2015-12-24 23:00:00\",\n" +
                "      \"treffpunkt\" : \"vor der Kirche\",\n" +
                "      \"id\" : \"4\",\n" +
                "      \"adjid\" : \"4\",\n" +
                "      \"dauer\" : null\n" +
                "   }\n" +
                "]");
        TerminAdapter terminAdapter = new TerminAdapter(getActivity().getLayoutInflater(), termine);
        ListView list = (ListView) contentView.findViewById(R.id.termin_liste);
        list.setAdapter(terminAdapter);

        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

package at.mvl.musikvereinleopoldsdorf.content;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

import at.mvl.musikvereinleopoldsdorf.R;
import at.mvl.musikvereinleopoldsdorf.content.adapters.TerminAdapter;
import at.mvl.mvllib.converter.JsonToTermin;
import at.mvl.mvllib.data.Termin;
import at.mvl.mvllib.tools.Downloader;
import at.mvl.mvllib.tools.StringArtist;

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
        termine = JsonToTermin.parseTermine(StringArtist.read(new File(getContext().getCacheDir().getParent()+"/termine.json")));
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

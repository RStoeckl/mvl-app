package at.mvl.musikvereinleopoldsdorf.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.mvl.musikvereinleopoldsdorf.R;

/**
 * Created by richi on 05.11.15.
 */
public class NetworkFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.set_network);
    }
}

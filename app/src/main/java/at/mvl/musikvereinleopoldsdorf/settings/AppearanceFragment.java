package at.mvl.musikvereinleopoldsdorf.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import at.mvl.musikvereinleopoldsdorf.R;

/**
 * Created by richi on 06.11.15.
 */
public class AppearanceFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.set_appearance);

    }
}

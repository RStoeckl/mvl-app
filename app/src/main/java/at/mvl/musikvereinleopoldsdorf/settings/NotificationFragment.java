package at.mvl.musikvereinleopoldsdorf.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Set;

import at.mvl.musikvereinleopoldsdorf.R;

/**
 * Created by richi on 06.11.15.
 */
public class NotificationFragment extends PreferenceFragment {

    private SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        addPreferencesFromResource(R.xml.set_notification);

        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        completeAlarmList();
    }

    private void completeAlarmList(){
        MultiSelectListPreference alarms = (MultiSelectListPreference) findPreference("alarm_list");
        alarms.setEntries(toSequence(prefs.getStringSet("user_alarm_list",null)));
    }

    private static CharSequence[] toSequence(Set<String> strings){
        ArrayList<CharSequence> ret = new ArrayList<>();
        for(String s : strings)
            ret.add(s);
        return ret.toArray(new CharSequence[ret.size()]);
    }
}

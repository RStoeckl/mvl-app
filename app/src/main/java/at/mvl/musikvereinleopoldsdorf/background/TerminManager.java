package at.mvl.musikvereinleopoldsdorf.background;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

/**
 * Created by richi on 27.11.15.
 */
public class TerminManager extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


        //TODO termine alarm
        //getTerminListe


        //enteferne alle abgelaufenen Termine
        //for(String key : prefs.getAll())

        //pruefe ob schon abgelaufen

        //wenn nicht → alarm und eintragen

        return super.onStartCommand(intent, flags, startId);
    }
}

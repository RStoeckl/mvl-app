package at.mvl.musikvereinleopoldsdorf.background;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;

/**
 * Created by richi on 16.11.15.
 */
public class Downloader extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {



        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Log.d("Download", "Download gestartet");

        File pathFile = getCacheDir().getParentFile();
        if (!pathFile.exists())
            pathFile.mkdirs();
        final String path = pathFile.toString();

        new AsyncTask<SharedPreferences, File, Void>() {
            @Override
            protected Void doInBackground(SharedPreferences... params) {
                at.mvl.mvllib.tools.Downloader.downloadToFile(prefs.getString("link_termine", ""), new File(path + "/termine.json"));
                Log.d("INFOBAUM",prefs.getString("link_termine","NIX"));
                //at.mvl.mvllib.tools.Downloader.downloadToFile(prefs.getString("link_preise", ""), new File(path + "/preise.json"));
                at.mvl.mvllib.tools.Downloader.downloadToFile(prefs.getString("link_stuecke", ""), new File(path + "/stuecke.json"));
                return null;
            }
        }.execute(prefs);



        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

package at.mvl.musikvereinleopoldsdorf.background;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import at.mvl.musikvereinleopoldsdorf.MainActivity;

/**
 * Created by richi on 16.11.15.
 */
public class StartFertig extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")) {
            startDownloader(context);
        }
    }

    public void startDownloader(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(MainActivity.ALARM_SERVICE);
        Intent startService = new Intent(context, Downloader.class);
        PendingIntent pIntent = PendingIntent.getService(context, 0, startService, 0);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000, pIntent);
    }
}

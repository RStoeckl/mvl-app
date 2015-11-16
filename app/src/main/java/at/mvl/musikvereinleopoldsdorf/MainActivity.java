package at.mvl.musikvereinleopoldsdorf;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import at.mvl.musikvereinleopoldsdorf.background.Downloader;
import at.mvl.musikvereinleopoldsdorf.background.StartFertig;
import at.mvl.musikvereinleopoldsdorf.content.MitgliederFragment;
import at.mvl.musikvereinleopoldsdorf.content.PreisFragment;
import at.mvl.musikvereinleopoldsdorf.content.StueckFragment;
import at.mvl.musikvereinleopoldsdorf.content.TerminFragment;
import at.mvl.musikvereinleopoldsdorf.content.VorstandFragment;
import at.mvl.musikvereinleopoldsdorf.settings.NetworkFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MitgliederFragment mitgliederFragment;
    private PreisFragment preisFragment;
    private StueckFragment stueckFragment;
    private TerminFragment terminFragment;
    private VorstandFragment vorstandFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StartFertig sf = new StartFertig();
        sf.startDownloader(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mitgliederFragment = new MitgliederFragment();
        preisFragment = new PreisFragment();
        stueckFragment = new StueckFragment();
        terminFragment = new TerminFragment();
        vorstandFragment = new VorstandFragment();
        if (savedInstanceState == null || !savedInstanceState.getString("callnotagain").equals("please")) {
            getSupportFragmentManager().beginTransaction().add(R.id.content_frame, stueckFragment).commit();
        } else {
            getSupportActionBar().setTitle(savedInstanceState.getCharSequence("title"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("callnotagain", "please");
        outState.putCharSequence("title", getSupportActionBar().getTitle());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.refresh) {
            Toast.makeText(this,"aktualisiert",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.delete_cache) {
            Toast.makeText(this,"Zwischenspiecher entleert",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_stuecke) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, stueckFragment).commit();
            getSupportActionBar().setTitle(R.string.stuecke);
        } else if (id == R.id.nav_mitglieder) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mitgliederFragment).commit();
            getSupportActionBar().setTitle(R.string.mitglieder);
        } else if (id == R.id.nav_vorstand) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, vorstandFragment).commit();
            getSupportActionBar().setTitle(R.string.vorstand);
        } else if (id == R.id.nav_termine) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, terminFragment).commit();
            getSupportActionBar().setTitle(R.string.termine);
        } else if (id == R.id.nav_preise) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, preisFragment).commit();
            getSupportActionBar().setTitle(R.string.preise);
        } else if (id == R.id.nav_settings) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new NetworkFragment()).commit();
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            getSupportActionBar().setTitle("Einstellungen");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

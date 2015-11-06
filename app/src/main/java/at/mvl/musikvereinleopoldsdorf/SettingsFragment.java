package at.mvl.musikvereinleopoldsdorf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by richi on 04.11.15.
 */
public abstract class SettingsFragment extends Fragment {

    private int layoutID;
    private View view;
    
    public abstract int setLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(setLayout(),null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void baum(){
        ArrayList<View> items = view.getTouchables();
        for(View singleView : items)
        {

        }
    }
}

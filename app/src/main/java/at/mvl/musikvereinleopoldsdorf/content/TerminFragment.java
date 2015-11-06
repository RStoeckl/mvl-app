package at.mvl.musikvereinleopoldsdorf.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import at.mvl.musikvereinleopoldsdorf.R;

/**
 * Created by richi on 02.11.15.
 */
public class TerminFragment extends Fragment {

    private View contentView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.termin_layout, null);
        ListView list = (ListView) contentView.findViewById(R.id.termin_liste);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

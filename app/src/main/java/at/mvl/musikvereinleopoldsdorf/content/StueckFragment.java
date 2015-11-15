package at.mvl.musikvereinleopoldsdorf.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.HashMap;

import at.mvl.musikvereinleopoldsdorf.R;
import at.mvl.musikvereinleopoldsdorf.content.adapters.StueckAdapter;
import at.mvl.mvllib.converter.JsonToBuchsammlung;
import at.mvl.mvllib.data.Buchsammlung;

/**
 * Created by richi on 02.11.15.
 */
public class StueckFragment extends Fragment {

    private View contentView;

    private Buchsammlung buecher;
    private ExpandableListView list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.stueck_layout, null);


        list = (ExpandableListView) contentView.findViewById(R.id.stueck_list);
        buecher = JsonToBuchsammlung.parseBuchsammlung("[\n" +
                "   {\n" +
                "      \"timestamp\" : \"Sat Nov 14 17:02:08 2015\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"bid\" : \"1\",\n" +
                "      \"name\" : \"Rotes Buch\",\n" +
                "      \"seiten\" : [\n" +
                "         {\n" +
                "            \"titel\" : \"Unter dem Doppeladler\",\n" +
                "            \"nummer\" : \"1\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"titel\" : \"Alte Kameraden\",\n" +
                "            \"nummer\" : \"2\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"titel\" : \"Radetzky-Marsch\",\n" +
                "            \"nummer\" : \"3\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"titel\" : \"Alt-Starhemberg Marsch\",\n" +
                "            \"nummer\" : \"4\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"titel\" : \"Oh du mein Österreich\",\n" +
                "            \"nummer\" : \"5\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"titel\" : \"Deutschmeister-Regiments-Marsch\",\n" +
                "            \"nummer\" : \"6\"\n" +
                "         }\n" +
                "      ]\n" +
                "   },\n" +
                "   {\n" +
                "      \"bid\" : \"2\",\n" +
                "      \"name\" : \"Grünes Buch\",\n" +
                "      \"seiten\" : [\n" +
                "         {\n" +
                "            \"titel\" : \"Willkommen - Na privitanou\",\n" +
                "            \"nummer\" : \"1\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"titel\" : \"Maruschka - Polka\",\n" +
                "            \"nummer\" : \"2\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"titel\" : \"Hei, ihr Gänschen, hei - Haj, Husicky, haj\",\n" +
                "            \"nummer\" : \"3\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"titel\" : \"Südböhmische Polka\",\n" +
                "            \"nummer\" : \"4\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"titel\" : \"Nas mate - Unser Matthias\",\n" +
                "            \"nummer\" : \"5\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"titel\" : \"Prerovanka\",\n" +
                "            \"nummer\" : \"6\"\n" +
                "         }\n" +
                "      ]\n" +
                "   },\n" +
                "   {\n" +
                "      \"bid\" : \"3\",\n" +
                "      \"name\" : \"Blaues Buch\",\n" +
                "      \"seiten\" : []\n" +
                "   },\n" +
                "   {\n" +
                "      \"bid\" : \"4\",\n" +
                "      \"name\" : \"Große Mappe\",\n" +
                "      \"seiten\" : []\n" +
                "   }\n" +
                "]");
        final StueckAdapter adapter = new StueckAdapter(buecher, getActivity().getLayoutInflater());
        list.setAdapter(adapter);

        EditText search = (EditText) contentView.findViewById(R.id.stueck_suche);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                HashMap<Integer, Boolean> exps = new HashMap<Integer, Boolean>();
                for (int i = 0; i < adapter.getGroupCount(); i++)
                    exps.put(i, list.isGroupExpanded(i));
                StueckAdapter adapter = new StueckAdapter(buecher.searchFor(s.toString()), getActivity().getLayoutInflater());
                list.setAdapter(adapter);
                for (int i = 0; i < adapter.getGroupCount(); i++)
                    if (exps.get(i))
                        list.expandGroup(i);
            }
        });
        list.requestFocus();
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}

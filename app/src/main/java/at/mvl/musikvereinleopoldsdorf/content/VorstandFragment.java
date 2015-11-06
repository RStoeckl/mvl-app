package at.mvl.musikvereinleopoldsdorf.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import at.mvl.musikvereinleopoldsdorf.R;
import at.mvl.musikvereinleopoldsdorf.WebViewPreparer;

/**
 * Created by richi on 02.11.15.
 */
public class VorstandFragment extends Fragment {

    private View contentView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.vorstand_layout, null);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WebView webView = (WebView) view.findViewById(R.id.vorstand_webView);
        WebViewPreparer.setPageWithCache(webView, "http://www.mvl.at/system/android/vorstand.php", getActivity());
    }
}

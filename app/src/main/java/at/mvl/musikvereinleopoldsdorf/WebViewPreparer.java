package at.mvl.musikvereinleopoldsdorf;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by richi on 02.11.15.
 */
public class WebViewPreparer {

    public static void setPageWithCache(WebView webview, String url, Activity activity)
    {
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setAppCacheMaxSize(5 * 1024 * 1024);
        webview.getSettings().setAppCachePath("/data/data/"+ activity.getPackageName() +"/cache");
        webview.getSettings().setAllowFileAccess(true);
        webview.getSettings().setAppCacheEnabled(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        if (!isNetworkAvailable(activity))
            webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webview.loadUrl(url);
    }

    private static boolean isNetworkAvailable(Activity activity)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

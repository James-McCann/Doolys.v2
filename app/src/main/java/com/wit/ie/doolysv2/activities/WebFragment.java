package com.wit.ie.doolysv2.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wit.ie.doolysv2.R;

public class WebFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.activity_web_fragment, container, false);

        WebView view = (WebView) fragmentView.findViewById(R.id.myWebView);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new MyBrowser());
        view.loadUrl("http://www.google.com/");

        return fragmentView;

    }


    private class MyBrowser extends WebViewClient {

        public boolean ShouldOverrideUrlLoading(WebView view, String Url) {

            view.loadUrl(Url);
            return true;
        }


    }

}














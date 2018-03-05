package com.realvouch.ggrt;

import android.webkit.WebResourceError;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

public interface IHio extends YopHelper {

    void partProgress();
    void hideProgress();
    void errorOne(WebResourceResponse errorResponse);
    void errorSecond(WebResourceError error);
    void errorThird();
    void fused(String data);

    WebView getView();
}

package com.realvouch.ggrt;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.realvouch.ggrt.gram.PoolStart;

import cn.iwgang.countdownview.CountdownView;


public class StrActivity extends AppCompatActivity implements IHio, ClassVaw {

    private static final String TAG = StrActivity.class.getSimpleName();

    private static final long TIME_CLOCK_MILLIS = 5 * 60 * 1000;

    @Override
    public void kil() {

    }

    @Override
    public void hit() {

    }

    @Override
    public void puck() {

    }

    private static class PresenterHolder {
        static final dasfsdfs INSTANCE = new dasfsdfs();
    }

    public StrActivity() {
        super();
    }

    @Override
    public void setTheme(int resid) {
        super.setTheme(resid);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
    }

    @Override
    public boolean supportRequestWindowFeature(int featureId) {
        return super.supportRequestWindowFeature(featureId);
    }

    @Override
    public void supportInvalidateOptionsMenu() {
        super.supportInvalidateOptionsMenu();
    }

    @Override
    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        super.onSupportActionModeStarted(mode);
    }

    private View mLayoutTimer;
    private View mLayoutWeb;
    private ImageView mButtonStart;
    private WebView webView;
    private ProgressBar progressBar;
    private CountdownView mClockView;

    private dasfsdfs mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        initViews();

        mLayoutTimer.setVisibility(View.VISIBLE);
        mLayoutWeb.setVisibility(View.GONE);

        setupAnimation();

        setupListener();

        mClockView.start(TIME_CLOCK_MILLIS); // Millisecond

        setupTtti(savedInstanceState);
    }

    private void initViews() {
        progressBar = findViewById(R.id.progress);
        webView = findViewById(R.id.web_view);
        mLayoutTimer = findViewById(R.id.layout_timer);
        mLayoutWeb = findViewById(R.id.layout_web_view);
        mButtonStart = findViewById(R.id.button_start);
        mClockView = findViewById(R.id.clock);
    }

    private void setupListener() {
        mLayoutTimer.setOnClickListener(view -> {
            mLayoutTimer.setVisibility(View.GONE);
            mLayoutWeb.setVisibility(View.VISIBLE);

            mPresenter.showWebView(
                    getString(R.string.opening_url),
                    getString(R.string.key_redirect)
            );
        });
    }

    private void setupAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.pulse);
        animation.setRepeatCount(ObjectAnimator.INFINITE);
        mButtonStart.setAnimation(animation);
    }
    private void setupTtti(Bundle savedInstanceState) {
        mPresenter = PresenterHolder.INSTANCE;
        mPresenter.setView(this);
        mPresenter.onCreateView(savedInstanceState);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void partProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void errorOne(WebResourceResponse errorResponse) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.e(TAG, "Error with code - " + errorResponse.getStatusCode());
        }
        openNext();
    }

    @Override
    public void errorSecond(WebResourceError error) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.e(TAG, "Error with code - " + error.getErrorCode());
        }
        openNext();
    }

    @Override
    public void errorThird() {
        openNext();
    }

    @Override
    public void fused(String data) {
        Log.i(TAG,"Load data");
    }

    @Override
    public WebView getView() {
        return webView;
    }

    @Override
    public void onStart(){
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    private void openNext() {
        Intent intent = new Intent(this, PoolStart.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }
}

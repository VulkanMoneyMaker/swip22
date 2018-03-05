package com.realvouch.ggrt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.concurrent.TimeUnit;


import io.reactivex.Observable;

public class SplSpls extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Observable.timer(1, TimeUnit.SECONDS)
               .subscribe(__ -> next());
    }


    private void next() {
        Intent intent = new Intent(this, StrActivity.class);
        startActivity(intent);
        finish();
    }
}

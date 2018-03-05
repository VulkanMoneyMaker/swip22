package com.realvouch.ggrt;

import com.realvouch.ggrt.gram.IKekti;

public abstract class IPopRti<T> implements IKekti {

    T mView;

    public void setView(T view) {
        this.mView = view;
    }

    public IPopRti() {
    }

    @Override
    public void onDestroy() {
    }
}
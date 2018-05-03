package com.example.android.genericlogin.base;

public class BasePresenter<V extends MvpView> implements Presenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    public boolean isViewAvailable() {
        return view != null;
    }

    public V getView() {
        return view;
    }
}

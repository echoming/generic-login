package com.example.android.genericlogin.base;

public interface Presenter<T extends MvpView> {
    void attachView(T view);

    void detachView();
}

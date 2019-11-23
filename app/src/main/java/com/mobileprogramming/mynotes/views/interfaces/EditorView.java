package com.mobileprogramming.mynotes.views.interfaces;

public interface EditorView {

    void showProgress();
    void hideProgress();
    void onRequestSuccess(String message);
    void onRequestError(String message);

}

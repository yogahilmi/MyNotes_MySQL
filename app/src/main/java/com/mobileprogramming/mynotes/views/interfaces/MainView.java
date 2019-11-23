package com.mobileprogramming.mynotes.views.interfaces;

import com.mobileprogramming.mynotes.models.Note;

import java.util.List;

public interface MainView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<Note> notes);
    void onErrorLoading(String message);

}

package com.mobileprogramming.mynotes.presenters;

import com.mobileprogramming.mynotes.api.ApiClient;
import com.mobileprogramming.mynotes.api.ApiInterface;
import com.mobileprogramming.mynotes.models.Note;
import com.mobileprogramming.mynotes.views.interfaces.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void getData(){

        view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Note>> call = apiInterface.getNotes();

        call.enqueue(new Callback<List<Note>>() {
            @Override
            public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body()!= null) {
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Note>> call, Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }
}

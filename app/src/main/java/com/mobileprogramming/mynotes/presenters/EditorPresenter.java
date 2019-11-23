package com.mobileprogramming.mynotes.presenters;

import com.mobileprogramming.mynotes.api.ApiClient;
import com.mobileprogramming.mynotes.api.ApiInterface;
import com.mobileprogramming.mynotes.models.Note;
import com.mobileprogramming.mynotes.views.interfaces.EditorView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorPresenter {

    private EditorView view;

    public EditorPresenter(EditorView view) {
        this.view = view;
    }

    public void saveNotes(String title, String notes, int color) {
        view.showProgress();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Note> call = apiInterface.saveNote(title, notes, color);
        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                view.hideProgress();

                if (response.isSuccessful() && response.body() != null) {
                    Boolean success = response.body().getSuccess();

                    if (success) {
                        view.onRequestSuccess(response.body().getMessage());

                    } else {
                        view.onRequestError(response.body().getMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                view.hideProgress();
                view.onRequestError(t.getLocalizedMessage());

            }
        });

    }

    public void deleteNotes(int id) {
        view.showProgress();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Note> call = apiInterface.deleteNote(id);
        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                view.hideProgress();

                if (response.isSuccessful() && response.body() != null) {
                    Boolean success = response.body().getSuccess();

                    if (success) {
                        view.onRequestSuccess(response.body().getMessage());

                    } else {
                        view.onRequestError(response.body().getMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                view.hideProgress();
                view.onRequestError(t.getLocalizedMessage());

            }
        });
    }

//    void updateNote(int id, String title, String note, int color) {
//        view.showProgress();
//        ApiInterface apiInterface;
//
//        Call<Note> call = apiInterface.updateNote(id, title, note, color);
//    }

    public void updateNotes(int id, String title, String notes, int color) {
        view.showProgress();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Note> call = apiInterface.updateNote(id, title, notes, color);
        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                view.hideProgress();

                if (response.isSuccessful() && response.body() != null) {
                    Boolean success = response.body().getSuccess();

                    if (success) {
                        view.onRequestSuccess(response.body().getMessage());

                    } else {
                        view.onRequestError(response.body().getMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                view.hideProgress();
                view.onRequestError(t.getLocalizedMessage());

            }
        });

    }

}

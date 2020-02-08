package com.wessam.freshmarketdemo.ui.home.presenter;

import androidx.annotation.NonNull;

import com.wessam.freshmarketdemo.model.remote.db.categories.Categories;
import com.wessam.freshmarketdemo.model.remote.network.ApiService;
import com.wessam.freshmarketdemo.model.remote.network.RetrofitClient;
import com.wessam.freshmarketdemo.ui.home.HomeView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenterImpl implements HomePresenter {

    private HomeView view;

    public HomePresenterImpl(HomeView view) {
        this.view = view;
    }

    @Override
    public void loadCategories() {
        Call<List<Categories>> call = RetrofitClient.getClient().create(ApiService.class).getCategories();

        call.enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(@NonNull Call<List<Categories>> call, @NonNull Response<List<Categories>> response) {
                List<Categories> categoriesList = response.body();

                if (categoriesList != null)
                    view.loadCategoriesInList(categoriesList);
            }

            @Override
            public void onFailure(@NonNull Call<List<Categories>> call, @NonNull Throwable t) {
            }
        });
    }

}
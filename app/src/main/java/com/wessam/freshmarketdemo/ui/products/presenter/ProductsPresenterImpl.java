package com.wessam.freshmarketdemo.ui.products.presenter;

import androidx.annotation.NonNull;

import com.wessam.freshmarketdemo.model.remote.db.categories.Categories;
import com.wessam.freshmarketdemo.model.remote.db.categories.Products;
import com.wessam.freshmarketdemo.model.remote.network.ApiService;
import com.wessam.freshmarketdemo.model.remote.network.RetrofitClient;
import com.wessam.freshmarketdemo.ui.products.ProductsView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsPresenterImpl implements ProductsPresenter {

    private ProductsView view;

    public ProductsPresenterImpl(ProductsView view) {
        this.view = view;
    }

    @Override
    public void loadProducts() {
        Call<Categories> call = RetrofitClient.getClient().create(ApiService.class).getProductsByCategoryId(view.getCategoryId());

        call.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call, @NonNull Response<Categories> response) {
                Categories categories = response.body();

                if (categories != null) {
                    view.getCurrentCategoryDetails(categories);

                    List<Products> productsList = categories.getProducts();
                    view.loadProductsInList(productsList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Categories> call, @NonNull Throwable t) {
            }
        });
    }

}

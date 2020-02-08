package com.wessam.freshmarketdemo.model.remote.network;

import com.wessam.freshmarketdemo.model.remote.db.categories.Categories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("categories")
    Call<List<Categories>> getCategories();

    @GET("categories/{category_id}")
    Call<Categories> getProductsByCategoryId(@Path("category_id") int categoryId);


}
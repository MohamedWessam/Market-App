package com.wessam.freshmarketdemo.model.remote.db.categories;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categories {

    private List<Products> products;

    @SerializedName("category_img")
    private String categoryImage;

    private String name;

    @SerializedName("id")
    private int categoryId;

    public Categories() {
    }

    public Categories(List<Products> products, String categoryImage, String name, int categoryId) {
        this.products = products;
        this.categoryImage = categoryImage;
        this.name = name;
        this.categoryId = categoryId;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
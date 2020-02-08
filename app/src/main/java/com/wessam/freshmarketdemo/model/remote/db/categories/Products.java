package com.wessam.freshmarketdemo.model.remote.db.categories;

import com.google.gson.annotations.SerializedName;

public class Products {

    @SerializedName("product_img")
    private String productImage;

    private String price;

    private String weight;

    private String name;

    @SerializedName("id")
    private int productId;

    public Products() {
    }

    public Products(String productImage, String price, String weight, String name, int productId) {
        this.productImage = productImage;
        this.price = price;
        this.weight = weight;
        this.name = name;
        this.productId = productId;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}

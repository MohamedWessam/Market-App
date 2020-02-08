package com.wessam.freshmarketdemo.ui.products;

import com.wessam.freshmarketdemo.model.remote.db.categories.Categories;
import com.wessam.freshmarketdemo.model.remote.db.categories.Products;

import java.util.List;

public interface ProductsView {

    void loadProductsInList(List<Products> productsList);

    void getCurrentCategoryDetails(Categories categories);

    int getCategoryId();

}

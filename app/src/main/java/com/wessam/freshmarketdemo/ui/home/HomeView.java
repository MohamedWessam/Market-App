package com.wessam.freshmarketdemo.ui.home;

import com.wessam.freshmarketdemo.model.remote.db.categories.Categories;

import java.util.List;

public interface HomeView {

    void loadCategoriesInList(List<Categories> categoriesList);

}

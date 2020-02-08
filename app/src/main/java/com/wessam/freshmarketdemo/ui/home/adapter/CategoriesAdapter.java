package com.wessam.freshmarketdemo.ui.home.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;
import com.wessam.freshmarketdemo.R;
import com.wessam.freshmarketdemo.constants.Constants;
import com.wessam.freshmarketdemo.model.remote.db.categories.Categories;
import com.wessam.freshmarketdemo.ui.products.ProductsActivity;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private Activity activity;
    private List<Categories> categoriesList;

    public CategoriesAdapter(Activity activity, List<Categories> categoriesList) {
        this.activity = activity;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.category_layout_item, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Categories categories = categoriesList.get(position);
        // set title
        holder.titleText.setText(categories.getName());
        // set picture
        Picasso.get().load(categories.getCategoryImage()).into(holder.categoryPicture);
        // on item click
        holder.itemView.setOnClickListener(view -> onItemClickListener(String.valueOf(categories.getCategoryId())));
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    private void onItemClickListener(String id) {
        Intent intent = new Intent(activity, ProductsActivity.class);
        intent.putExtra(Constants.CATEGORY_ID_KEY, String.valueOf(id));
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    class CategoriesViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView titleText;
        private KenBurnsView categoryPicture;

        CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.category_title);
            categoryPicture = itemView.findViewById(R.id.category_image);
        }
    }

}
package com.wessam.freshmarketdemo.ui.products.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.wessam.freshmarketdemo.R;
import com.wessam.freshmarketdemo.constants.Constants;
import com.wessam.freshmarketdemo.model.remote.db.categories.Products;
import com.wessam.freshmarketdemo.ui.productdetails.ProductDetailsActivity;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {

    private Activity activity;
    private List<Products> productsList;

    public ProductsAdapter(Activity activity, List<Products> productsList) {
        this.activity = activity;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.product_layout_item, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Products products = productsList.get(position);
        // set values to recycler item
        holder.productName.setText(products.getName());
        holder.productPrice.setText(products.getPrice());
        holder.productWeight.setText(products.getWeight());
        Picasso.get().load(products.getProductImage()).into(holder.productImage);
        // on item click listener
        holder.itemView.setOnClickListener(view -> onItemClickListener(products));
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    private void onItemClickListener(Products product) {
        Intent intent = new Intent(activity, ProductDetailsActivity.class);
        intent.putExtra(Constants.PRODUCT_KEY, new Gson().toJson(product));
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    class ProductsViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView productName, productPrice, productWeight;
        private AppCompatImageView productImage;
        private AppCompatImageButton productAddButton;

        ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name_text);
            productPrice = itemView.findViewById(R.id.product_price_text);
            productWeight = itemView.findViewById(R.id.product_weight_text);
            productImage = itemView.findViewById(R.id.product_image);
            productAddButton = itemView.findViewById(R.id.product_add_button);
        }
    }

}
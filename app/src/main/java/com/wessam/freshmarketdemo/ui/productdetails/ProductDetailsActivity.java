package com.wessam.freshmarketdemo.ui.productdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.google.gson.Gson;
import com.wessam.freshmarketdemo.R;
import com.wessam.freshmarketdemo.constants.Constants;
import com.wessam.freshmarketdemo.databinding.ActivityProductDetailsBinding;
import com.wessam.freshmarketdemo.model.remote.db.categories.Products;

public class ProductDetailsActivity extends AppCompatActivity {

    private ActivityProductDetailsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_details);

        receiveChosenProductName();
    }

    private void receiveChosenProductName() {
        String   intent     = getIntent().getStringExtra(Constants.PRODUCT_KEY);
        Products productObj = new Gson().fromJson(intent, Products.class);

        String name = productObj.getName();

        mBinding.productDetailsNameText.setText(name);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
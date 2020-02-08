package com.wessam.freshmarketdemo.ui.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.wessam.freshmarketdemo.R;
import com.wessam.freshmarketdemo.constants.Constants;
import com.wessam.freshmarketdemo.databinding.ActivityProductsBinding;
import com.wessam.freshmarketdemo.model.remote.db.categories.Categories;
import com.wessam.freshmarketdemo.model.remote.db.categories.Products;
import com.wessam.freshmarketdemo.ui.products.adapter.ProductsAdapter;
import com.wessam.freshmarketdemo.ui.products.presenter.ProductsPresenter;
import com.wessam.freshmarketdemo.ui.products.presenter.ProductsPresenterImpl;

import java.util.List;
import java.util.Objects;

public class ProductsActivity extends AppCompatActivity implements ProductsView {

    private ActivityProductsBinding mBinding;
    private ProductsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_products);

        mPresenter = new ProductsPresenterImpl(this);

        initializeComponents();

        mBinding.productsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mPresenter.loadProducts();

    }

    private void initializeComponents() {
        // make activity full screen
        // this also required to make custom style in styles.xml
        // and make parent layout in xml fitSystemWindow="true"
        Window                     window    = getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        window.setAttributes(winParams);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        // initialize toolbar
        setSupportActionBar(mBinding.productsAppbar.productsToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public int getCategoryId() {
        Intent intent = getIntent();
        return Integer.parseInt(Objects.requireNonNull(intent.getStringExtra(Constants.CATEGORY_ID_KEY)));
    }

    @Override
    public void getCurrentCategoryDetails(Categories categories) {
        Picasso.get().load(categories.getCategoryImage()).into(mBinding.productsAppbar.collapsingBarImage);
        mBinding.productsAppbar.toolbarTitle.setText(categories.getName());
    }

    @Override
    public void loadProductsInList(List<Products> productsList) {
        ProductsAdapter adapter = new ProductsAdapter(ProductsActivity.this, productsList);
        mBinding.productsRecyclerView.setAdapter(adapter);
    }

    /**
     * show menu of toolbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.light_toolbar_menu, menu);
        return true;
    }

    /**
     * handle toolbar icons on click listener
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle on toolbar icons click
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_cart:
                Toast.makeText(this, "Cart pressed", Toast.LENGTH_SHORT).show();
                // todo later -> navigate to cart activity
                break;
            case R.id.action_search:
                Toast.makeText(this, "Search pressed", Toast.LENGTH_SHORT).show();
                // todo later -> implement search
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
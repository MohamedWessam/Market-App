package com.wessam.freshmarketdemo.ui.home;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.wessam.freshmarketdemo.R;
import com.wessam.freshmarketdemo.databinding.ActivityHomeBinding;
import com.wessam.freshmarketdemo.model.remote.db.categories.Categories;
import com.wessam.freshmarketdemo.ui.home.adapter.AutoImageSliderAdapter;
import com.wessam.freshmarketdemo.ui.home.adapter.CategoriesAdapter;
import com.wessam.freshmarketdemo.ui.home.presenter.HomePresenter;
import com.wessam.freshmarketdemo.ui.home.presenter.HomePresenterImpl;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeView {

    private ActivityHomeBinding mBinding;
    private HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        initializeComponents();

        mPresenter = new HomePresenterImpl(this);

        mBinding.content.categoriesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mPresenter.loadCategories();

    }

    private void initializeComponents() {
        //prepare slider view
        AutoImageSliderAdapter adapter = new AutoImageSliderAdapter();
        mBinding.content.sliderView.setSliderAdapter(adapter);
        mBinding.content.sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE);
        mBinding.content.sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        // initialize toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        // initialize navigation drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mBinding.mainDrawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        toggle.syncState();
    }

    @Override
    public void loadCategoriesInList(List<Categories> categoriesList) {
        CategoriesAdapter adapter = new CategoriesAdapter(HomeActivity.this, categoriesList);
        mBinding.content.categoriesRecyclerView.setAdapter(adapter);
    }

    /**
     * show menu of toolbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dark_toolbar_menu, menu);
        return true;
    }

    /**
     * handle toolbar icons on click listener
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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

}
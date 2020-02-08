package com.wessam.freshmarketdemo.ui.home.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;
import com.wessam.freshmarketdemo.R;

public class AutoImageSliderAdapter extends SliderViewAdapter<AutoImageSliderAdapter.SliderAdapterVH> {

    // prepare images url arrays
    private static final String[] IMAGES_URL = new String[]{
            "https://i.postimg.cc/NF4Q6ZRf/h1.jpg",
            "https://i.postimg.cc/4NfffNTK/h3.jpg",
            "https://i.postimg.cc/D0f9T0bn/h2.jpg",
            "https://i.postimg.cc/SsL44HT7/h4.jpg"
    };

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        @SuppressLint("InflateParams") View inflate =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.auto_image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        // load images in image view
        Picasso.get().load(IMAGES_URL[position]).into(viewHolder.imageViewBackground);
    }

    @Override
    public int getCount() {
        //slider view count
        return 4;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        AppCompatImageView imageViewBackground;

        SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.auto_slider_image);
            this.itemView = itemView;
        }
    }
}
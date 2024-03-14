package com.example.finalyearproject.java;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.finalyearproject.R;

import java.io.IOException;
import java.io.InputStream;

public class UsingMapFragment extends Fragment {
    // Array to store ImageView IDs
    private final int[] imageViewIds = {
            R.id.mapPart0, R.id.mapPart1, R.id.mapPart2, R.id.mapPart3, R.id.mapPart4, R.id.mapPart5,
            R.id.mapPart6, R.id.mapPart7, R.id.mapPart8, R.id.mapPart9, R.id.mapPart10, R.id.mapPart11,
            R.id.mapPart12, R.id.mapPart13, R.id.mapPart14, R.id.mapPart15, R.id.mapPart16, R.id.mapPart17,
            R.id.mapPart18, R.id.mapPart19, R.id.mapPart20, R.id.mapPart21, R.id.mapPart22, R.id.mapPart23,
            R.id.mapPart24, R.id.mapPart25, R.id.mapPart26, R.id.mapPart27
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_using_map, container, false);

        // Load and set images for ImageView elements
        loadImages(view);

        return view;
    }

    private void loadImages(View view) {
        try {
            // Iterate through ImageView IDs and load corresponding images
            for (int i = 0; i < imageViewIds.length; i++) {
                ImageView imageView = view.findViewById(imageViewIds[i]);
                String imageName = i + ".jpg";
                InputStream inputStream = requireActivity().getAssets().open(imageName);
                Bitmap bitmapImg = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmapImg);
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

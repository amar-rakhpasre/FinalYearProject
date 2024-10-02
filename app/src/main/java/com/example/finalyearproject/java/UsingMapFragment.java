package com.example.finalyearproject.java;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.finalyearproject.R;
import com.example.finalyearproject.MumbaiMapZoon.*;

import java.io.IOException;
import java.io.InputStream;

public class UsingMapFragment extends Fragment {


        private final int[] imageViewIds = {
                R.id.mapPart0, R.id.mapPart1, R.id.mapPart2, R.id.mapPart3, R.id.mapPart4, R.id.mapPart5,
                R.id.mapPart6, R.id.mapPart7, R.id.mapPart8, R.id.mapPart9, R.id.mapPart10, R.id.mapPart11,
                R.id.mapPart12, R.id.mapPart13, R.id.mapPart14, R.id.mapPart15, R.id.mapPart16, R.id.mapPart17,
                R.id.mapPart18, R.id.mapPart19, R.id.mapPart20, R.id.mapPart21, R.id.mapPart22, R.id.mapPart23,
                R.id.mapPart24, R.id.mapPart25, R.id.mapPart26, R.id.mapPart27

        };

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_home_using_map, container, false);
                loadImages(view);
                return view;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);

                setImageViewClickListeners(view);
        }

        private void setImageViewClickListeners(View view) {
                int[] selectedIds = {R.id.mapPart0, R.id.mapPart2, R.id.mapPart3, R.id.mapPart4, R.id.mapPart6,
                        R.id.mapPart7, R.id.mapPart8, R.id.mapPart10, R.id.mapPart11, R.id.mapPart14,
                        R.id.mapPart15, R.id.mapPart17, R.id.mapPart18, R.id.mapPart19, R.id.mapPart21,
                        R.id.mapPart22};

                for (int i = 0; i < selectedIds.length; i++) {
                        ImageView imageView = view.findViewById(selectedIds[i]);
                        final int index = i; // Store the index of the clicked ImageView
                        imageView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                        navigateToFragment(index); // Pass the index to the navigateToFragment method
                                }
                        });
                }
        }


        private void navigateToFragment(int index) {
                Fragment fragment = null;
                switch (index) {
                        case 0:
                                fragment = new Z1Fragment();
                                break;
                        case 1:
                                fragment = new Z2Fragment();
                                break;
                        case 2:
                                fragment = new Z3Fragment();
                                break;
                        case 3:
                                fragment = new Z4Fragment();
                                break;
                        case 4:
                                fragment = new Z5Fragment();
                                break;
                        case 5:
                                fragment = new Z6Fragment();
                                break;
                        case 6:
                                fragment = new Z7Fragment();
                                break;
                        case 7:
                                fragment = new Z8Fragment();
                                break;
                        case 8:
                                fragment = new Z9Fragment();
                                break;
                        case 9:
                                fragment = new Z10Fragment();
                                break;
                        case 10:
                                fragment = new Z11Fragment();
                                break;
                        case 11:
                                fragment = new Z12Fragment();
                                break;
                        case 12:
                                fragment = new Z13Fragment();
                                break;
                        case 13:
                                fragment = new Z14Fragment();
                                break;
                        case 14:
                                fragment = new Z15Fragment();
                                break;
                        case 15:
                                fragment = new Z16Fragment();
                                break;
                        // Add cases for other image indices as needed
                        default:
                                break;
                }

                if (fragment != null) {
                        getParentFragmentManager().beginTransaction()
                                .replace(R.id.frame_layout, fragment)
                                .addToBackStack(null)
                                .commit();
                }
        }

        private void loadImages(View view) {
                try {
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

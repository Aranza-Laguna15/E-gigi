package com.example.user.e_gigi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DetProduct extends Fragment {
    private static final String EXTRA_SAMPLE = "sample";

    public DetProduct() {
        // Required empty public constructor
    }

    public static DetProduct newInstance() {
        DetProduct fragment = new DetProduct();
        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_det_product, container, false);
        ImageView imageView=(ImageView)view.findViewById(R.id.product);
        DrawableCompat.setTint(imageView.getDrawable(), 1214);
        return view;
    }

}

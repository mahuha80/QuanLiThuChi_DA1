package com.example.duan1_vinh.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_vinh.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ColorFragment extends Fragment {
    TableLayout tableLayout;
    boolean isSelected = false;
    CircleImageView circleImageView;
    ArrayList<CircleImageView> circleImageViewArrayList = new ArrayList<>();
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        circleImageView=view.findViewById(R.id.civ);
        return view;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show();
                int ColorCode = circleImageView.getDrawingCache().getPixel(290    , 290);

                Toast.makeText(context,ColorCode+"" , Toast.LENGTH_SHORT).show();
            }
        });
    }
}

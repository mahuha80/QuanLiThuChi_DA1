package com.example.duan1_vinh.ui;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    boolean isSelected=false;
    ArrayList<CircleImageView> circleImageViewArrayList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        tableLayout = view.findViewById(R.id.tb_fragment_color);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int row=6;
        int col=4;
        for(int i=0;i<row;i++){
            TableRow tableRow=new TableRow(getActivity().getApplicationContext());
            for(int j=0;j<col;j++){
                final CircleImageView circleImageView=new CircleImageView(getActivity().getApplicationContext());
                final int vitricolor=col*i+j;
                final int idhinhcolor=getResources().getIdentifier(MainActivity.arrayImg.get(vitricolor),"drawable",getActivity().getPackageName());
                circleImageView.setImageResource(idhinhcolor);
                circleImageView.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onClick(View v) {
                        if(isSelected){
                            for(int i=0;i<circleImageViewArrayList.size();i++){
                                circleImageViewArrayList.get(i).setBorderWidth(0);
                            }
                        }
                        isSelected=true;
                        circleImageView.setBorderColor(getResources().getColor(R.color.orange));
                        circleImageView.setBorderWidth(10);
                        circleImageView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                        isSelected = true;
                        ColorDrawable colorDrawable= (ColorDrawable) circleImageView.getBackground();
                        Toast.makeText(getActivity().getApplicationContext(), colorDrawable.getColor()+"", Toast.LENGTH_SHORT).show();

                    }
                });
                tableRow.addView(circleImageView);
                circleImageView.setPadding(66,16,16,16);
                circleImageViewArrayList.add(circleImageView);
            }

            tableLayout.addView(tableRow);
        }

    }
}

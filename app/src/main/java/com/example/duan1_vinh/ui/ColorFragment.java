package com.example.duan1_vinh.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_vinh.R;

public class ColorFragment extends Fragment {
    TableLayout tableLayout;
    static boolean isSelected=false;
    static int idhinhselect=0;

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
                ImageView imageView=new ImageView(getActivity().getApplicationContext());
                final int vitri=col*i+j;
                final int idhinh=getResources().getIdentifier(MainActivity.arrayImg.get(vitri),"drawable",getActivity().getPackageName());
                imageView.setImageResource(idhinh);
                tableRow.addView(imageView);
                imageView.setPadding(66,16,16,16);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isSelected=true;
                        idhinhselect=vitri;
                    }
                });
            }

            tableLayout.addView(tableRow);
        }

    }
}

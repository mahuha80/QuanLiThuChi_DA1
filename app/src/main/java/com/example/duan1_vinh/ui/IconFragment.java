package com.example.duan1_vinh.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_vinh.R;

public class IconFragment extends Fragment {
    static boolean isSelected = false;
    static int idhinhselect = -1;
    TableLayout tableLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_icon, container, false);
        tableLayout = view.findViewById(R.id.table_layout_Icon);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int row = 12;
        int col = 4;
        for (int i = 0; i < row; i++) {
            TableRow tableRow = new TableRow(getActivity().getApplicationContext());
            for (int j = 0; j < col; j++) {
                ImageView imageView = new ImageView(getActivity().getApplicationContext());
                final int vitri = col * i + j;
                final int idhinh = getResources().getIdentifier(MainActivity.arrayIcon.get(vitri), "drawable", getActivity().getPackageName());
                imageView.setImageResource(idhinh);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), vitri+"", Toast.LENGTH_SHORT).show();
                    }
                });
                tableRow.addView(imageView);
                imageView.setPadding(66, 16, 16, 16);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isSelected = true;
                        idhinhselect = vitri;
                    }
                });
            }

            tableLayout.addView(tableRow);
        }
    }
}

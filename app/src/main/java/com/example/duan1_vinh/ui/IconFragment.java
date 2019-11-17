package com.example.duan1_vinh.ui;

import android.graphics.drawable.ColorDrawable;
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

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class IconFragment extends Fragment {
    TableLayout tableLayout;
    boolean isChecked = false;
    ArrayList<CircleImageView> circleImageViewArrayList = new ArrayList<>();

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
//                ImageView imageView = new ImageView(getActivity().getApplicationContext());
                final CircleImageView circleImageView = new CircleImageView(getActivity().getApplicationContext());
                final int vitriicon = col * i + j;
                final int idhinhicon = getResources().getIdentifier(MainActivity.arrayIcon.get(vitriicon), "drawable", getActivity().getPackageName());
                circleImageView.setImageResource(idhinhicon);

                circleImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isChecked) {
                            for(int i=0;i<circleImageViewArrayList.size();i++){
                                circleImageViewArrayList.get(i).setBorderWidth(0);
                            }
                        }
                        circleImageView.setBorderColor(getResources().getColor(R.color.design_default_color_primary));
                        circleImageView.setBorderWidth(10);
                        circleImageView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                        isChecked = true;


                    }
                });
                tableRow.addView(circleImageView);
                circleImageView.setPadding(66, 16, 16, 16);
                circleImageViewArrayList.add(circleImageView);

            }

            tableLayout.addView(tableRow);
        }
    }
}

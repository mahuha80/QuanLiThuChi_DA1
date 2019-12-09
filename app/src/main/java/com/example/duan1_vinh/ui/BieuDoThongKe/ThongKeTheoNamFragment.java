package com.example.duan1_vinh.ui.BieuDoThongKe;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.dao.KhoanChiDAO;
import com.example.duan1_vinh.dao.KhoanThuDAO;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ThongKeTheoNamFragment extends Fragment {
    KhoanThuDAO khoanThuDAO;
    private Context context;
    TextView textView;
    KhoanChiDAO khoanChiDAO;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongketheonam, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView=view.findViewById(R.id.textView4);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        khoanThuDAO=new KhoanThuDAO(context);

    }

    @Override
    public void onResume() {
        super.onResume();
        khoanChiDAO=new KhoanChiDAO(context);
        List<Double> list=new ArrayList<>();
        list=khoanChiDAO.getTongTungThang();
        for(int i=0;i<list.size();i++){
            textView.append(list.get(i)+"\n");
        }
    }
}

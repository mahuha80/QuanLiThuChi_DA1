package com.example.duan1_vinh.ui.CaiDat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.dao.KhoanThuDAO;
import com.example.duan1_vinh.model.KhoanThu;
import com.example.duan1_vinh.ui.MainActivity;
import com.example.duan1_vinh.ui.ThongKeChiTiet.ThongKeChiTietModel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaiDatFragment extends Fragment {


    private ThongKeChiTietModel thongKeChiTietModel;
    Button btnRating;
    private Context context;
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    NotificationChannel channel;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        thongKeChiTietModel =
                ViewModelProviders.of(this).get(com.example.duan1_vinh.ui.ThongKeChiTiet.ThongKeChiTietModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnRating = view.findViewById(R.id.btnRating);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        CharSequence name = "My Notification";
        String description = "yadda yadda";
        channel = new NotificationChannel("1", name, importance);
        channel.setDescription(description);

        builder = new NotificationCompat.Builder(context.getApplicationContext(), channel.getId())
                .setSmallIcon(R.drawable.group);

        notificationManager.createNotificationChannel(channel);

        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Person jd = new Person.Builder()
                        .setName("QUAN LI THU CHI")
                        .setImportant(true)
                        .build();

                new NotificationCompat.MessagingStyle(jd)
                        .addMessage("thank you for rating us", new Date().getTime(), jd)
                        .setBuilder(builder);


                notificationManager.notify(1, builder.build());
            }
        });
    }


}
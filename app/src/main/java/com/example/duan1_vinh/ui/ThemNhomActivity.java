package com.example.duan1_vinh.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1_vinh.R;
import com.example.duan1_vinh.ui.FragmentPagerAdapter.ThemNhomPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ThemNhomActivity extends AppCompatActivity {
    ViewPager viewPager;
    ThemNhomPagerAdapter themNhomPagerAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhom);
        viewPager = findViewById(R.id.vp_themnhom_activity);
        tabLayout = findViewById(R.id.tl_themnhom_activity);
        themNhomPagerAdapter = new ThemNhomPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(themNhomPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.done, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.done:
//                   Intent intent = new Intent();
//                   intent.putExtra("idhinhselect", ColorFragment.idhinhselect+"");
//                   setResult(RESULT_OK,intent);
//                   finish();
//                   break;


        }
        return super.onOptionsItemSelected(item);
    }
}

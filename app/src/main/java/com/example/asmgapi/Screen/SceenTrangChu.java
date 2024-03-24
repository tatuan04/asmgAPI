package com.example.asmgapi.Screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asmgapi.Fragment.Fragment_TrangChu;
import com.example.asmgapi.R;
import com.google.android.material.navigation.NavigationView;

public class SceenTrangChu extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FrameLayout frameLayout;
    ImageView imgProfile;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sceen_trang_chu);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frameLayout);
        imgProfile = findViewById(R.id.imgProfile);
        Fragment_TrangChu frgSP = new Fragment_TrangChu();
        relaceFrg(frgSP);
        if (savedInstanceState == null) {
            relaceFrg(new Fragment_TrangChu());
            setTitle("Trang chủ");
        }
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SceenTrangChu.this,SceenProfile.class);
                startActivity(intent);
                Toast.makeText(SceenTrangChu.this, "Đăng nhập", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void relaceFrg(Fragment frg) {
        FragmentManager fg = getSupportFragmentManager();
        fg.beginTransaction().replace(R.id.frameLayout, frg).commit();
    }
}
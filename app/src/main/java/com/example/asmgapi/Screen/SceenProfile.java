package com.example.asmgapi.Screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asmgapi.R;

public class SceenProfile extends AppCompatActivity {
        ImageView img_Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sceen_profile);
        img_Back=  findViewById(R.id.img_Back);
        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SceenProfile.this,SceenTrangChu.class);
                startActivity(intent);
                Toast.makeText(SceenProfile.this, "Đăng nhập", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
package com.example.asmgapi.Screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.asmgapi.R;

public class MainActivity extends AppCompatActivity {
    private static final int DA1 = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ScreenLogin.class );
                startActivity(intent);
                finish();
            }
        }, DA1 );
    }
}
package com.example.asmgapi.Screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asmgapi.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SceenRegister extends AppCompatActivity {
    TextInputEditText edtUser,edtPass;
    TextInputLayout in_User, in_Pass;
    AppCompatButton btnRegister;
    TextView txtDangnhap_dk,txtQuenMk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sceen_register);
        txtDangnhap_dk = findViewById(R.id.txtDangnhap_dk);
        in_User = findViewById(R.id.in_User_dk);
        in_Pass = findViewById(R.id.in_Pass_dk);
        edtUser = findViewById(R.id.edtUser_dk);
        edtPass = findViewById(R.id.edtPass_dk);
        btnRegister = findViewById(R.id.btnRegister);
        txtDangnhap_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SceenRegister.this,ScreenLogin.class);
                startActivity(intent);
                Toast.makeText(SceenRegister.this, "Đăng nhập", Toast.LENGTH_SHORT).show();

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SceenRegister.this, ScreenLogin.class);
                startActivity(intent);
                Toast.makeText(SceenRegister.this, "Đăng kí Thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
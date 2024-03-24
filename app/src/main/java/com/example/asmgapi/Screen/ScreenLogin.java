package com.example.asmgapi.Screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asmgapi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ScreenLogin extends AppCompatActivity {
    TextInputEditText edtUser,edtPass;
    TextInputLayout in_User, in_Pass;
    AppCompatButton btnLOGIN;
    TextView txtDangki_dn,txtQuenMk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_login);
        //anh xa
        txtDangki_dn = findViewById(R.id.txtDangki_dn);
        txtQuenMk = findViewById(R.id.txtQuenMk);
        in_User = findViewById(R.id.in_User);
        in_Pass = findViewById(R.id.in_Pass);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLOGIN = findViewById(R.id.btnLOGIN);
        CheckBox chkNho = findViewById(R.id.chkNho);
        txtDangki_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScreenLogin.this,SceenRegister.class);
                startActivity(intent);
                Toast.makeText(ScreenLogin.this, "Đăng ký", Toast.LENGTH_SHORT).show();

            }
        });
        btnLOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ScreenLogin.this, SceenTrangChu.class);
                startActivity(intent);
                Toast.makeText(ScreenLogin.this, "Đăng nhập Thành công", Toast.LENGTH_SHORT).show();
            }
        });

        txtQuenMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogForgot();
            }
        });
    }

    private void showDialogForgot() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_forgot, null);
        builder.setView(view);
        EditText edtEmail = view.findViewById(R.id.edtEmail);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);

        // Thiết lập sự kiện khi nhấn nút "CÓ"
        builder.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        // Thiết lập sự kiện khi nhấn nút "Cancel"
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog.dismiss();
            }
        });

        builder.create().show();
    }
}

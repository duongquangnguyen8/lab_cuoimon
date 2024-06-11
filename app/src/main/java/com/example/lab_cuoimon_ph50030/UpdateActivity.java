package com.example.lab_cuoimon_ph50030;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.io.FileOutputStream;
import java.io.IOException;

public class UpdateActivity extends AppCompatActivity {
    TextInputLayout txtInputMsv,txtInputHoTen;
    Button btnDangNhap;
    String textMsv;
    String textHoTen;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        Intent intent=this.getIntent();
        txtInputMsv.getEditText().setText(intent.getStringExtra("MaSinhVien"));
        txtInputHoTen.getEditText().setText(intent.getStringExtra("HoTen"));
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textMsv=txtInputMsv.getEditText().getText().toString();
                textHoTen=txtInputHoTen.getEditText().getText().toString();
                boolean check1=false;
                boolean check2=false;
                if (textMsv.length()<3){
                    txtInputMsv.setError("Bạn cần nập tối thiểu 3 kí tự");
                    check1=true;
                }
                else {
                    txtInputMsv.setError(null);
                    check1=false;
                }
                if (textHoTen.length()<3){
                    txtInputHoTen.setError("Bạn cần nhập tối thiểu 3 kí tự");
                    check2=true;
                }
                else {
                    txtInputHoTen.setError(null);
                    check2=false;
                }
                if (!check1&&!check2){
                    ghiDuLieu();
                    Intent intent=new Intent(UpdateActivity.this,SinhVienActivity.class);
                    intent.putExtra("msv",textMsv);
                    intent.putExtra("ten",textHoTen);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(UpdateActivity.this, "Bạn cần nhập đúng yêu cầu", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void init(){
        txtInputHoTen=findViewById(R.id.txtInputHoten);
        txtInputMsv=findViewById(R.id.txtInputMSV);
        btnDangNhap=findViewById(R.id.btnDangNhap);
    }
    public void ghiDuLieu(){
        try {
            FileOutputStream fileOutputStream=openFileOutput("data.txt", Context.MODE_APPEND);
            String thongtinsinhvien="MSV: "+textMsv+"Họ tên: "+textHoTen;
            fileOutputStream.write(thongtinsinhvien.getBytes());
            fileOutputStream.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
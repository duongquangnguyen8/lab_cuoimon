package com.example.lab_cuoimon_ph50030;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_cuoimon_ph50030.adapter.SinhVienAdapter;
import com.example.lab_cuoimon_ph50030.models.SinhVien;

import java.util.ArrayList;

public class SinhVienActivity extends AppCompatActivity {

    private SinhVienAdapter sinhVienAdapter;
    private ArrayList<SinhVien> dsSinhVien;
    private ListView listSinhVien;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sinh_vien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        setSupportActionBar(toolbar);
        ActionBar bar=getSupportActionBar();
        bar.setTitle("Danh sách sinh viên");
        bar.setDisplayShowTitleEnabled(true);
        dsSinhVien=new ArrayList<>();
        dsSinhVien.add(new SinhVien("Ph1","Nguyễn Quang Dương",R.drawable.img));
        dsSinhVien.add(new SinhVien("Ph2","Nguyễn Quang Hưng",R.drawable.img_6));
        dsSinhVien.add(new SinhVien("Ph3","Đỗ Thị Hiền",R.drawable.hien));
        dsSinhVien.add(new SinhVien("Ph4","Trần Trọng Dương",R.drawable.tranduong));
        dsSinhVien.add(new SinhVien("Ph5","Nguyễn Đức Sơn",R.drawable.son));
        sinhVienAdapter=new SinhVienAdapter(SinhVienActivity.this,dsSinhVien);

        listSinhVien.setAdapter(sinhVienAdapter);
        listSinhVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int postion, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(SinhVienActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có chắc chắn xoá không");
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dsSinhVien.remove(postion);
                        sinhVienAdapter.notifyDataSetChanged();
                    }
                });
                AlertDialog dialog=builder.create();
                builder.show();
                return true;
            }
        });
        listSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long l) {
                Intent intent=new Intent(SinhVienActivity.this,UpdateActivity.class);
                intent.putExtra("MaSinhVien",dsSinhVien.get(postion).getMsv());
                intent.putExtra("HoTen",dsSinhVien.get(postion).getTen());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.hienThi){
            Intent intent=new Intent(SinhVienActivity.this,ThongTinActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void init(){
        listSinhVien=findViewById(R.id.listSinhVien);
        toolbar=findViewById(R.id.toolbar);
    }
}
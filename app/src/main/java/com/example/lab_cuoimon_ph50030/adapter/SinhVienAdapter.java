package com.example.lab_cuoimon_ph50030.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab_cuoimon_ph50030.R;
import com.example.lab_cuoimon_ph50030.models.SinhVien;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SinhVien> dsSinhVien;

    public SinhVienAdapter(Context context, ArrayList<SinhVien> dsSinhVien) {
        this.context = context;
        this.dsSinhVien = dsSinhVien;
    }

    @Override
    public int getCount() {
        return dsSinhVien.size();
    }

    @Override
    public Object getItem(int i) {
        return dsSinhVien.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row;
        if(view!=null){
            row=view;
        }
        else{
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            row=inflater.inflate(R.layout.listview_1dong,null);
        }

        SinhVien sv=dsSinhVien.get(i);
        TextView tv_msv=row.findViewById(R.id.tvMSV);
        TextView tv_ten=row.findViewById(R.id.tvHoTen);
        ImageView img_Anh=row.findViewById(R.id.imgAnh);

        tv_msv.setText("MSV: "+sv.getMsv());
        tv_ten.setText("Họ tên: "+sv.getTen());
        img_Anh.setImageResource(sv.getId());
        return row;

    }
}

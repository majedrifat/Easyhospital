package com.majedul.easyHospital.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.majedul.easyHospital.Adapter.HospitalViewAdapter;
import com.majedul.easyHospital.ModelClass.Hospital;
import com.majedul.easyHospital.R;

import java.util.ArrayList;

public class HospitalActivity extends AppCompatActivity {

    ArrayList<Hospital> arrayList = new ArrayList<>();
    String[] name,status,phone,open,hospitaldoctor;
    int[] img = {R.drawable.japan, R.drawable.apollo,
    R.drawable.images,R.drawable.central,R.drawable.sprc,R.drawable.islami,
            R.drawable.health
    };
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        name = getResources().getStringArray(R.array.h_name);
        status = getResources().getStringArray(R.array.h_status);
        phone = getResources().getStringArray(R.array.h_phone);
        open = getResources().getStringArray(R.array.h_open);
       // hospitaldoctor =getResources().getStringArray(R.array.HealthAndHopedoctorDoctorsName);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        int i = 0;

        for(String Name:name){

            arrayList.add(new Hospital(Name,status[i],open[i],phone[i],img[i],hospitaldoctor));
            i++;

        }
        adapter = new HospitalViewAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);
    }
}

package com.majedul.easyHospital.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.majedul.easyHospital.Adapter.DrInfoAdapter;
import com.majedul.easyHospital.Database.DrInfoManager;
import com.majedul.easyHospital.ModelClass.DrInfo;
import com.majedul.easyHospital.R;

import java.util.ArrayList;

public class DrInfoListActivity extends AppCompatActivity {
    ListView drInfoLV;
    DrInfoAdapter drInfoAdapter;
    DrInfoManager drInfoManager;
    ArrayList<DrInfo>drInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_info_list);

        drInfoLV= (ListView) findViewById(R.id.drInfoLV);
        drInfoManager= new DrInfoManager(this);
        drInfos= drInfoManager.getAllDrInfo();
        drInfoAdapter= new DrInfoAdapter(this,drInfos);
        drInfoLV.setAdapter(drInfoAdapter);

        drInfoLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int drId= drInfos.get(position).getId();
                Intent intent= new Intent(DrInfoListActivity.this,DrInfoUpdateDltActivity.class);
                intent.putExtra("id",drId);
                startActivity(intent);

            }
        });

    }

    public void moveToInsertPage(View view) {
        Intent intent= new Intent(DrInfoListActivity.this,DrInfoInsertActivity.class);
        startActivity(intent);
    }

    public void home(View view) {
        Intent intent= new Intent(DrInfoListActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}

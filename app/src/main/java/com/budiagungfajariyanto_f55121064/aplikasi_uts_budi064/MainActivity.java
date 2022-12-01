package com.budiagungfajariyanto_f55121064.aplikasi_uts_budi064;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.budiagungfajariyanto_f55121064.RinciActivity;
import com.budiagungfajariyanto_f55121064.List;
import com.budiagungfajariyanto_f55121064.ListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ListAdapter adapter;
    private ArrayList<List> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ListAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, lists.get(i).getName(), Toast.LENGTH_SHORT).show();
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, RinciActivity.class));
                }
            }
        });

    }

    private void prepare() {
        dataName = getResources(). getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        lists = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            List member = new List();
            member.setPhoto(dataPhoto.getResourceId(i, -1));
            member.setName(dataName[i]);
            member.setDescription(dataDescription[i]);
            lists.add(member);
        }
        adapter.setMembers(lists);
    }
}
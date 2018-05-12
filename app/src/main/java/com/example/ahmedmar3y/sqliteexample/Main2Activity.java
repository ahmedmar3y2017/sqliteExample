package com.example.ahmedmar3y.sqliteexample;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // init list
        listView = (ListView) findViewById(R.id.listView);

        // find All From Database
        sqliteHelper sqliteHelper = new sqliteHelper(this);
        ArrayList<HashMap<String, String>> userList = sqliteHelper.GetEmployees();
        ListAdapter adapter = new SimpleAdapter(Main2Activity.this, userList, R.layout.mylist, new String[]{"name", "address", "salary"}, new int[]{R.id.name, R.id.address, R.id.salary});

        listView.setAdapter(adapter);


    }


    public void backAction(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }
}

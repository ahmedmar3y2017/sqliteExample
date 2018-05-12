package com.example.ahmedmar3y.sqliteexample;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahmed mar3y on 12/05/2018.
 */

public class myListAdapter extends ArrayAdapter<String> {

    final Activity context;

    ArrayList<Employee> employees;

    public myListAdapter(Activity context, ArrayList<Employee> employees) {
        super(context, R.layout.mylist);
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.mylist, null, true);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView address = (TextView) view.findViewById(R.id.address);
        TextView salary = (TextView) view.findViewById(R.id.salary);

        Log.d("Names : ", employees.get(position).getName());
        name.setText(employees.get(position).getName());
        address.setText(employees.get(position).getAddress());
        salary.setText(String.valueOf(employees.get(position).getSalary()));


        return view;

    }
}

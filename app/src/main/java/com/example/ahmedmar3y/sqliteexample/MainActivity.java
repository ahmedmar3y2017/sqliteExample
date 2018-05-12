package com.example.ahmedmar3y.sqliteexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText address;
    EditText salary;


    sqliteHelper sqliteHelper = new sqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // edittexts
        name = (EditText) findViewById(R.id.employeeName);
        address = (EditText) findViewById(R.id.employeeAddress);
        salary = (EditText) findViewById(R.id.employeeSalary);


    }




    public void saveButtonClick(View view) {
        Log.d("loo", "done");

        String empName = name.getText().toString();
        String empAddress = address.getText().toString();
        String empSalary = salary.getText().toString();
        if (empName.trim().isEmpty()
                || empAddress.trim().isEmpty()
                || empSalary.trim().isEmpty()
                ) {
            Toast.makeText(this, "Error Enter all Fields ", Toast.LENGTH_LONG).show();

        } else {
            sqliteHelper.insertEmployee(new Employee(empName, empAddress, Double.parseDouble(empSalary)));

        }


    }

    public void showAllClick(View view) {

        Intent intent = new Intent(this, Main2Activity.class);

        startActivity(intent);


    }
}

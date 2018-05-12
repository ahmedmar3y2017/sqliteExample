package com.example.ahmedmar3y.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ahmed mar3y on 12/05/2018.
 */

public class sqliteHelper extends SQLiteOpenHelper {


    public sqliteHelper(Context context) {
        super(context, "mydb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("CREATE TABLE employee (id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT , address TEXT , salary INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // if there is new Version
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS employee");

        onCreate(sqLiteDatabase);

    }

    public void insertEmployee(Employee employee) {


        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", employee.getName());
        contentValues.put("address", employee.getAddress());
        contentValues.put("salary", employee.getSalary());

        sqLiteDatabase.insert("employee", null, contentValues);

        sqLiteDatabase.close();


    }


    // Get User Details
    public ArrayList<HashMap<String, String>> GetEmployees() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT name, address, salary FROM employee";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("name", cursor.getString(cursor.getColumnIndex("name")));
            user.put("address", cursor.getString(cursor.getColumnIndex("address")));
            user.put("salary", String.valueOf(cursor.getInt(cursor.getColumnIndex("salary"))));
            userList.add(user);
        }
        return userList;
    }

    public ArrayList<Employee> getAllEmployee() {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();


        ArrayList<Employee> employees = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from employee", null);

        if (cursor.moveToFirst()) {
            do {

                Employee employee = new Employee(cursor.getString(1), cursor.getString(2), cursor.getInt(3));
                employees.add(employee);

            } while (cursor.moveToNext());


        }


        return employees;
    }


}

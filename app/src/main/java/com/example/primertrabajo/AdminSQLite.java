package com.example.primertrabajo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AdminSQLite extends SQLiteOpenHelper {
    public AdminSQLite(
            Context context,

            String nombre,
            SQLiteDatabase.CursorFactory factory,
            int version)
    {
        super(context, nombre, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table usuario(id INTEGER not null primary key AUTOINCREMENT ,usuario text, email text, pass text, confirmarPass text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {
        db.execSQL("create table usuario(id INTEGER not null primary key AUTOINCREMENT ,usuario text, email text, pass text, confirmarPass text)");
    }

}

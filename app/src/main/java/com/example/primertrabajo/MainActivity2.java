package com.example.primertrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1 = (EditText)findViewById(R.id.txt_nombreUsuario);
        e2 = (EditText)findViewById(R.id.txt_email);
        e3 = (EditText)findViewById(R.id.txt_pass);
        e4 = (EditText)findViewById(R.id.txt_confirmarpass);
        btn_volver = (Button)findViewById(R.id.btn_volver);
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cerrar();
            }
        });
    }

    public void alta(View v){
        AdminSQLite admin = new AdminSQLite(this, "misusuarios", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String usuario = e1.getText().toString().trim().toUpperCase();
        String email = e2.getText().toString().trim().toUpperCase();
        String pass = e3.getText().toString().trim().toUpperCase();
        String confirmarPass = e4.getText().toString().trim().toUpperCase();

        ContentValues registro = new ContentValues();
        registro.put("usuario", usuario);
        registro.put("email", email);
        registro.put("pass", pass);
        registro.put("confirmarPass", confirmarPass);

        bd.insert("usuario", null, registro);
        bd.close();

        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();

    }

    public void Cerrar(){
        finish();
    }
}
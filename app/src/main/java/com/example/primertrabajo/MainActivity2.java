package com.example.primertrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    Button btn_volver;
    UsuarioSQL asql;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1 = (EditText) findViewById(R.id.txt_nombreUsuario);
        e2 = (EditText) findViewById(R.id.txt_nombre);
        e3 = (EditText) findViewById(R.id.txt_email);
        e4 = (EditText) findViewById(R.id.txt_pass);
        btn_volver = (Button) findViewById(R.id.btn_volver);
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cerrar();
            }
        });
        asql= new UsuarioSQL(this);

    }

    public void Registrar(View v){
        Usuario u = new Usuario();
        u.setUsuario(e1.getText().toString());
        u.setNombre(e2.getText().toString());
        u.setEmail(e3.getText().toString());
        u.setPassword(e4.getText().toString());
        if(!u.isNull()){
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else if (asql.insertUsuario(u)){
            Toast.makeText(this, "Registro existoso de usuario", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "El nombre usuario ya esta registrado", Toast.LENGTH_SHORT).show();
        }
    }
        public void alta (View v){
            AdminSQLite admin = new AdminSQLite(this, "misusuarios", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();

            String usuario = e1.getText().toString().trim().toUpperCase();
            String nombre = e2.getText().toString().trim().toUpperCase();
            String email = e3.getText().toString().trim().toUpperCase();
            String pass = e4.getText().toString().trim().toUpperCase();

            ContentValues registro = new ContentValues();
            registro.put("usuario", usuario);
            registro.put("nombre", nombre);
            registro.put("email", email);
            registro.put("pass", pass);

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

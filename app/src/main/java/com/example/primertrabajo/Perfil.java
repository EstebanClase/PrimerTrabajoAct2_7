package com.example.primertrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {
    TextView usuario, nombre, email;
    Button btn_detalles;
    int id;
    Usuario u;
    UsuarioSQL asql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        usuario = (TextView)findViewById(R.id.txtusuario);
        nombre = (TextView)findViewById(R.id.txtnombre);
        email = (TextView)findViewById(R.id.txtemail);
        btn_detalles = (Button)findViewById(R.id.btn_detallesP);
        btn_detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Detalles();
            }
        });
        Bundle b = getIntent().getExtras();
        id = b.getInt("Id");
        asql = new UsuarioSQL(this);
        u = asql.getUsuarioId(id);
        usuario.setText(u.getUsuario());
        nombre.setText(u.getNombre());
        email.setText(u.getEmail());
    }

    public void Detalles(){
        Intent detalles = new Intent(this, MainActivity3.class);
        startActivity(detalles);
    }
}
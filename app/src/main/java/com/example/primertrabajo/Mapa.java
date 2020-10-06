package com.example.primertrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mapa extends AppCompatActivity {

    TextView txt_nombreEscogido;
    Button btn_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        txt_nombreEscogido = (TextView) findViewById(R.id.txt_nombreEscogido);
        Intent inte = this.getIntent();
        String n = inte.getStringExtra("nickname").toString();
        txt_nombreEscogido.setText(n);
        btn_perfil = (Button)findViewById(R.id.btn_perfil);
        btn_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Perfil();
            }
        });
    }

    public void Perfil(){
        Intent perfil = new Intent(this, Perfil.class);
        startActivity(perfil);
    }
}
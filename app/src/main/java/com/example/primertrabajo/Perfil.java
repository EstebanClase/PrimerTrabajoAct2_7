package com.example.primertrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Perfil extends AppCompatActivity {

    Button btn_detalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        btn_detalles = (Button)findViewById(R.id.btn_detallesP);
        btn_detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Detalles();
            }
        });
    }

    public void Detalles(){
        Intent detalles = new Intent(this, MainActivity4.class);
        startActivity(detalles);
    }
}
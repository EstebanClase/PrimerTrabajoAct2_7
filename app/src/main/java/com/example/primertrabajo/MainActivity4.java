package com.example.primertrabajo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity4 extends AppCompatActivity {
    RecyclerView MiRecycler;
    String nombre[], fund[];
    int imagenes [] ={R.drawable.usuario};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        MiRecycler = (RecyclerView)findViewById(R.id.MiRecicler);
        nombre = getResources().getStringArray(R.array.equipos);
        fund = getResources().getStringArray(R.array.anios);

        MiAdapter MA = new MiAdapter(this, this.nombre, this.fund, this.imagenes);
        MiRecycler.setAdapter(MA);
        MiRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
package com.example.primertrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Button btn_empezar;
    EditText nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nickname = (EditText)findViewById(R.id.txt_nombreEscogido);
        btn_empezar = (Button)findViewById(R.id.btn_empezar);
        btn_empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empezar();
            }
        });


    }

    public void Empezar(){
        Intent empezar = new Intent(this, MapsActivity.class);
        empezar.putExtra("nickname", nickname.getText().toString());
        startActivity(empezar);
    }

}

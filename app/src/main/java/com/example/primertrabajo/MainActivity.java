package com.example.primertrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_ingresar, btn_registrar;
    SensorManager misensorManager;
    Sensor misensor;
    SensorEventListener milistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ingresar = (Button) findViewById(R.id.btn_ingresar);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ingresar();
            }
        });
        btn_registrar = (Button) findViewById(R.id.btn_registrar);
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Registrar();
            }
        });
        misensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        misensor = misensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (misensor == null) {
            finish();
        }

        milistener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0] < misensor.getMaximumRange()) {
                    sound();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        comenzar();
    }

    public void Ingresar(){
        Intent ingresar = new Intent(this, MainActivity3.class);
        startActivity(ingresar);
        detener();
    }

    public void Registrar(){
        Intent registrar = new Intent(this, MainActivity2.class);
        startActivity(registrar);
    }

    private void sound(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sound_short);
        mediaPlayer.start();
    }

    public void comenzar(){
        misensorManager.registerListener(milistener, misensor, 2000000);
    }

    public void detener(){
        misensorManager.unregisterListener(milistener);
    }

    @Override
    protected void onPause() {
        detener();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
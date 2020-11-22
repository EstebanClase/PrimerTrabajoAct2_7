package com.example.primertrabajo;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker m1,m2,m3,m4,m5,m6,m7,m8,m9;
    TextView txt_nombreEscogido;
    Button btn_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        int estado = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if(estado == ConnectionResult.SUCCESS) {

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }
        else{
            Dialog mens = GooglePlayServicesUtil.getErrorDialog(estado,(Activity) getApplicationContext(), 10);
            mens.show();
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        UiSettings USet = mMap.getUiSettings();
        USet.setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng LosParrones = new LatLng(-30.610999, -71.214327);
        mMap.addMarker(new MarkerOptions().position(LosParrones).title("Marcador en Los Parrones").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        float zoom = 16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LosParrones, zoom));

        LatLng negocio1 = new LatLng(-30.612823, -71.212825);
        m1 = googleMap.addMarker(new MarkerOptions().position(negocio1).title("Minimarket el Portal").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng negocio2 = new LatLng(-30.613554, -71.212058);
        m2 = googleMap.addMarker(new MarkerOptions().position(negocio2).title("Amazanderia Martinez").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

        LatLng negocio3 = new LatLng(-30.613233, -71.211255);
        m3 = googleMap.addMarker(new MarkerOptions().position(negocio3).title("Minimarket el Portal III").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng negocio4 = new LatLng(-30.612871, -71.212461);
        m4 = googleMap.addMarker(new MarkerOptions().position(negocio4).title("Almacen Belen y Miguel").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        LatLng negocio5 = new LatLng(-30.613975, -71.211642);
        m5 = googleMap.addMarker(new MarkerOptions().position(negocio5).title("Riquisimo").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        LatLng negocio6 = new LatLng(-30.611558, -71.213717);
        m6 = googleMap.addMarker(new MarkerOptions().position(negocio6).title("San Joaquin").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng negocio7 = new LatLng(-30.611747, -71.214320);
        m7 = googleMap.addMarker(new MarkerOptions().position(negocio7).title("Canicerica el buen cerdo").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng negocio8 = new LatLng(-30.610179, -71.214442);
        m8 = googleMap.addMarker(new MarkerOptions().position(negocio8).title("Botilleria la estrella").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng negocio9 = new LatLng(-30.613233, -71.211255);
        m9 = googleMap.addMarker(new MarkerOptions().position(negocio9).title("Minimarket el Portal III").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));



        googleMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        if(marker.equals(m1)){

            Negocio1.newInstamnce(marker.getTitle(),getString(R.string.negocio1)).show(getSupportFragmentManager(), null);
        }
        if(marker.equals(m2)){
            Negocio1.newInstamnce(marker.getTitle(),getString(R.string.negocio2)).show(getSupportFragmentManager(), null);
        }
        if(marker.equals(m3)){
            Negocio1.newInstamnce(marker.getTitle(),getString(R.string.negocio3)).show(getSupportFragmentManager(), null);
        }
        if(marker.equals(m4)){

            Negocio1.newInstamnce(marker.getTitle(),getString(R.string.negocio4)).show(getSupportFragmentManager(), null);
        }
        if(marker.equals(m5)){

            Negocio1.newInstamnce(marker.getTitle(),getString(R.string.negocio5)).show(getSupportFragmentManager(), null);
        }
        if(marker.equals(m6)){

            Negocio1.newInstamnce(marker.getTitle(),getString(R.string.negocio6)).show(getSupportFragmentManager(), null);
        }
        if(marker.equals(m7)){

            Negocio1.newInstamnce(marker.getTitle(),getString(R.string.negocio7)).show(getSupportFragmentManager(), null);
        }
        if(marker.equals(m8)){

            Negocio1.newInstamnce(marker.getTitle(),getString(R.string.negocio8)).show(getSupportFragmentManager(), null);
        }
        if(marker.equals(m9)){

            Negocio1.newInstamnce(marker.getTitle(),getString(R.string.negocio9)).show(getSupportFragmentManager(), null);
        }
    }



    public void Perfil(){
        finish();
    }
}
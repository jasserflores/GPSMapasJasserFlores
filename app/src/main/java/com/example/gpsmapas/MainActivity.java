package com.example.gpsmapas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtlat, txtlon;

    GoogleMap mMapa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtlat = findViewById(R.id.txtlatitud);
        txtlon = findViewById(R.id.txtlongitud);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap){
    mMapa = googleMap;
    this.mMapa.setOnMapClickListener(this);
    this.mMapa.setOnMapLongClickListener(this);

        SedeST("arica", -18.4833856, -70.3103754);
        SedeST("iquique", -20.2397762, -70.1448787);
        SedeST("antofagasta", -23.6347315, -70.3940526);
        SedeST("la serena", -29.9051257, -71.2638824);
        SedeST("santiago",  -33.45694, -70.64827);
        SedeST("viña", -33.02457, -71.55183);
        SedeST("talca", -35.4264, -71.65542);
        SedeST("concepción",-36.82699, -73.04977 );
        SedeST("los angeles", -37.46973, -72.35366);
        SedeST("temuco", -38.73965, -72.59842);
        SedeST("valdivia", -39.8174169, -73.2331328);
        SedeST("osorno", -40.5717908, -73.1377152);
        SedeST("puerto montt", -41.4693, -72.94237);

    }
    private void SedeST(String title, double latitude, double longitude) {
        LatLng locations = new LatLng(latitude, longitude);
        mMapa.addMarker(new MarkerOptions().position(locations).title(title));
        mMapa.moveCamera(CameraUpdateFactory.newLatLng(locations));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng){
        txtlat.setText("" + latLng.latitude);
        txtlon.setText("" + latLng.longitude);
    }
    public void Video (View view){
        Intent video = new Intent(this, SedesSanto.class);
        startActivity(video);
    }
    @Override
    public void onMapLongClick(@NonNull LatLng latLng){
        txtlat.setText("" + latLng.latitude);
        txtlon.setText("" + latLng.longitude);
    }


}

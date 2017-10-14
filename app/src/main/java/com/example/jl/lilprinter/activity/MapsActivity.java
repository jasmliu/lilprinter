package com.example.jl.lilprinter.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.model.Printer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ArrayList<Printer> printers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        printers = new ArrayList<>();
        createPrinters();
    }

    private void createPrinters() {
        Printer woodys = new Printer();
        woodys.setLat(33.778967);
        woodys.setLng(-84.406499);
        printers.add(woodys);
    }

    /**.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Printer woodys = printers.get(0);
        LatLng woodys_latlng = new LatLng(woodys.getLat(), woodys.getLng());
        Marker woodys_marker = mMap.addMarker(new MarkerOptions().position(woodys_latlng));
        woodys_marker.setTag(woodys);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
              @Override
              public boolean onMarkerClick(Marker marker) {
                  //retrieve Printer from the marker
                  Printer printer = (Printer) marker.getTag();

                  Intent intent = new Intent(MapsActivity.this, PrinterViewActivity.class);
                  intent.putExtra("printer", printer);
                  startActivity(intent);
                  return false;
              }
          });

    }
}


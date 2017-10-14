package com.example.jl.lilprinter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.model.Printer;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;

    private ArrayList<Printer> printers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getExtras().getString("user").equals("ADMIN")) {
            setContentView(R.layout.activity_maps_admin);
        } else {
            setContentView(R.layout.activity_maps_users);
        }

        if (getIntent().getExtras().getString("user").equals("ADMIN")) {
            FloatingActionButton fabAddPrinter = findViewById(R.id.fabAddPrinter);
            fabAddPrinter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), LoginActivity.class);
                    intent.putExtra("user", getIntent().getExtras().getString("user"));
                    startActivity(intent);
                }
            });
        }

        FloatingActionButton fabLogin = findViewById(R.id.fabLogin);
        fabLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                intent.putExtra("user", getIntent().getExtras().getString("user"));
                startActivity(intent);
            }
        });

        FloatingActionButton fabList = findViewById(R.id.fabList);
        fabList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListActivity.class);
                intent.putExtra("user", getIntent().getExtras().getString("user"));
                startActivity(intent);
            }
        });



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        printers = new ArrayList<>();
        createPrinters();
    }

    private void createPrinters() {
        //todo: create printers from data file?
        Printer woodys = new Printer();
        woodys.setId(1);
        woodys.setLocation("woody's");
        woodys.setLat(33.778967);
        woodys.setLng(-84.406499);
        printers.add(woodys);

        Printer library = new Printer();
        library.setId(2);
        library.setLocation("library");
        library.setLat(33.774401);
        library.setLng(-84.395841);
        printers.add(library);
    }

    /**.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //restrict user panning
        LatLngBounds tech = new LatLngBounds(new LatLng(33.771403, -84.407349),
                new LatLng(33.781547, -84.390801));
        mMap.setLatLngBoundsForCameraTarget(tech);

        //todo: center camera on current location. if not within tech bounds, center on tech

        //creates markers from printers list
        //todo: set marker icons as printers (design)
        for (Printer p : printers) {
            LatLng latlng = new LatLng(p.getLat(), p.getLng());
            Marker marker = mMap.addMarker(new MarkerOptions().position(latlng));
            marker.setTag(p); //pairs marker with Printer object
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
              @Override
              public boolean onMarkerClick(Marker marker) {
              Printer printer = (Printer) marker.getTag(); //retrieve Printer object from the marker

              //view printer info
              Intent intent = new Intent(MapsActivity.this, PrinterViewActivity.class);
              intent.putExtra("printer", printer);
              startActivity(intent);
              return false;
              }
          });

    }
}


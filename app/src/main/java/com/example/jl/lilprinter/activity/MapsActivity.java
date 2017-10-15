package com.example.jl.lilprinter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.model.Printer;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private final String TAG = "Map Activity Error";

    private GoogleMap mMap;
    private DatabaseReference mDatabase, printerCloudEndPoint;
    private ChildEventListener mChildEventListener;
    private BitmapDescriptor printer_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        printerCloudEndPoint = mDatabase.child("printers");
        FirebaseAuth auth = FirebaseAuth.getInstance();
        getIntent().putExtra("test", "test");
        if (getIntent().getStringExtra("user") == null) {
            getIntent().putExtra("user", "");
        }
        setContentView(R.layout.activity_maps);
        Log.d(TAG, "Hello World");
        Log.d(TAG, getIntent().getExtras().getString("user"));
        FloatingActionButton fabAddPrinter = findViewById(R.id.fabAddPrinter);
        fabAddPrinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                intent.putExtra("user", getIntent().getStringExtra("user"));
                startActivity(intent);
            }
        });

        FloatingActionButton fabLogin = findViewById(R.id.fabLogin);
        fabLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                intent.putExtra("user", getIntent().getStringExtra("user"));
                startActivity(intent);
            }
        });

        FloatingActionButton fabList = findViewById(R.id.fabList);
        fabList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapsActivity.this, PrinterRecyclerViewActivity.class);
                intent.putExtra("user", getIntent().getStringExtra("user"));
                startActivity(intent);
            }
        });



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        dataRead();
        printerCloudEndPoint.addChildEventListener(mChildEventListener);
    }

    /**.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //restrict user panning
        printer_icon = BitmapDescriptorFactory.fromResource(R.drawable.printer_good);
        LatLngBounds tech = new LatLngBounds(new LatLng(33.771403, -84.407349), new LatLng(33.781547, -84.390801));
        mMap.setLatLngBoundsForCameraTarget(tech);

        //todo: center camera on current location. if not within tech bounds, center on tech

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
              @Override
              public boolean onMarkerClick(Marker marker) {
              Printer printer = (Printer) marker.getTag(); //retrieve Printer object from the marker

              //view printer info
              Intent intent = new Intent(MapsActivity.this, PrinterDetailActivity.class);
              intent.putExtra("user", getIntent().getStringExtra("user"));
              intent.putExtra("printer", printer);
              startActivity(intent);
              return false;
              }
          });

    }

    private void dataRead() {
        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Printer printer = dataSnapshot.getValue(Printer.class);
                    LatLng latlng = new LatLng(printer.getLat(), printer.getLng());
                    if (!printer.getStatus()) {
                        printer_icon = BitmapDescriptorFactory.fromResource(R.drawable.printer_bad);
                    }
                    Marker marker = mMap.addMarker(new MarkerOptions().position(latlng).icon(printer_icon));
                    marker.setTag(printer);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    for (DataSnapshot printerSnapshot : dataSnapshot.getChildren()) {
                        Printer printer = printerSnapshot.getValue(Printer.class);
                        LatLng latlng = new LatLng(printer.getLat(), printer.getLng());
                        Marker marker = mMap.addMarker(new MarkerOptions().position(latlng));
                        marker.setTag(printer);
                    }
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
        }
    }
}


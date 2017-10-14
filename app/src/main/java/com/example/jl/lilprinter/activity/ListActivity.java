package com.example.jl.lilprinter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.adapter.PrinterViewHolder;
import com.example.jl.lilprinter.data.PrinterAdapter;
import com.example.jl.lilprinter.model.Printer;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivityERROR";

    private DatabaseReference mDatabase;
    private DatabaseReference printerCloudEndPoint;

    private List<Printer> mPrinters;

    private ChildEventListener mChildEventListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mDatabase =  FirebaseDatabase.getInstance().getReference();
        printerCloudEndPoint = mDatabase.child("printers");

        //list of printers pulled from database
        mPrinters = new ArrayList<>();

        mPrinters.add(new Printer());

        /*
        printerCloudEndPoint.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot printerSnapshot : dataSnapshot.getChildren()) {
                    Printer printer = printerSnapshot.getValue(Printer.class);
                    mPrinters.add(printer);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });*/

        dataRead();
        Log.v(TAG, "CHOCOLATE" + mPrinters.get(0));
    }

    private void dataRead() {
        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Printer value = dataSnapshot.getValue(Printer.class);
                    Log.v(TAG, "SODA" + value.getLocation());
                    Log.v(TAG, "COOKIE" + value);
                    mPrinters.add(value);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    for (DataSnapshot printerSnapshot : dataSnapshot.getChildren()) {
                        Printer printer = printerSnapshot.getValue(Printer.class);
                        mPrinters.add(printer);
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
            printerCloudEndPoint.addChildEventListener(mChildEventListener);
            Log.v(TAG, "CHOCOLATE" + Integer.toString(mPrinters.size()));
        }
    }

}

//initial printer data add; disregard
/**
 mPrinterAdapter = new PrinterAdapter();
 for (Printer p : new Printers().getPrinters()) {
 mPrinterAdapter.writePrinter(p);
 }**/
